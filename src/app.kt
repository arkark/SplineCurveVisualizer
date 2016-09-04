import processing.core.PApplet
import processing.event.MouseEvent
import java.util.ArrayList
import util.Function

class App : PApplet() {
    private val points: ArrayList<Vec3> = ArrayList()
    private val vectors: ArrayList<Vec3> = ArrayList()
    private val radius: Float = 10f

    private var dragging: Boolean = false
    private var draggingIndex: Int = 0

    private val detail: Int = 100 // スプライン曲線の精度
    private val speed: Float = 6f // 1フレームあたりに進む距離
    private var diff: Float = 200f // 速度ベクトルの大きさ
    private var time: Float = 0f // 時間
    private var nowIndex: Int = 0

    override fun settings() {
        size(600, 600, P3D)
    }

    override fun setup() {
        background(0f)
        strokeWeight(3f)
    }

    override fun draw() {
        background(0f)

        if (dragging) drag()

        val s = points.size

        // 点間の線分の描画
        stroke(255f, 40f)
        for(i in 0..s-1) {
            line(points[i].x, points[i].y, points[(i+1)%s].x, points[(i+1)%s].y)
        }

        // 各点の速度ベクトルの描画
        stroke(0f, 100f, 255f, 100f)
        for(i in 0..s-1) {
            line(points[i].x, points[i].y, points[i].x+vectors[i].x*diff/10f, points[i].y+vectors[i].y*diff/10f)
        }

        // スプライン曲線の描画
        stroke(210f, 120f, 0f)
        for(i in 0..s-1) {
            for(j in 0..detail-1) {
                val t1 = Function.linear(j, 0, 1, detail).toFloat()
                val t2 = Function.linear(j+1, 0, 1, detail).toFloat()
                val p1 = calcPos(t1, i, (i+1)%s)
                val p2 = calcPos(t2, i, (i+1)%s)
                line(p1.x, p1.y, p2.x, p2.y)
            }
        }

        // 各点の描画
        for(i in 0..s-1) {
            if (dragging && i == draggingIndex) {
                stroke(100f, 100f, 255f)
                fill(100f, 100f, 255f, 100f)
            } else if (i == s-1) {
                stroke(100f, 255f, 100f)
                fill(100f, 255f, 100f, 100f)
            } else {
                stroke(255f)
                fill(255f, 100f)
            }
            ellipse(points[i].x, points[i].y, 2f*radius, 2f*radius)
        }

        // 動点の描画
        stroke(255f, 120f, 100f)
        fill(255f, 120f, 100f, 200f)
        if (s > 1) {
            val p = calc()
            ellipse(p.x, p.y, 2f * radius, 2f * radius)
        }

        time++
    }

    override fun mousePressed() {
        if (!dragging) {
            if (mouseButton == LEFT) {
                val p = Vec3(mouseX.toFloat(), mouseY.toFloat(), 0f)
                val i = points.indexOfFirst {
                    collide(p, it)
                }
                if (i < 0) {
                    if (points.isEmpty()) {
                        points.add(p)
                        vectors.add(Vec3(0f, 0f, 0f))
                    } else {
                        points.add(p)
                        val s = points.size
                        vectors[s-2] = calcVec(s-2, (s*2-3)%s, s-1)
                        vectors.add(
                                calcVec(s-1, s-2, 0)
                        )
                        vectors[0] = calcVec(0, s-1, 1)
                    }
                } else {
                    dragging = true
                    draggingIndex = i
                }
            } else if (mouseButton == RIGHT && !points.isEmpty()) {
                points.remove(points[points.size-1])
                vectors.remove(vectors[vectors.size-1])
                if (!points.isEmpty()) nowIndex %= points.size
            }
        }
    }

    override fun mouseWheel(event: MouseEvent) {
        val e = event.getCount().toFloat()
        diff *= exp(e/10f)
    }

    fun collide(p1: Vec3, p2: Vec3): Boolean {
        return lengthSq(p1-p2) < pow(2f*radius, 2f)
    }

    fun calcVec(o: Int, i: Int, j: Int): Vec3 {
        val p = points[o]
        val p1 = points[i]
        val p2 = points[j]
        return normalize(normalize(p2-p) - normalize(p1-p))
    }

    fun calc(): Vec3 {
        var i = 0
        var j = 0
        var t = 0f
        while(true) {
            i = nowIndex
            j = (i+1)%points.size
            t = time * speed / calcLeng(i, j)
            if (t > 1f) {
                time -= calcLeng(i, j) / speed
                nowIndex = (nowIndex+1)%points.size
            } else {
                break
            }
        }
        return calcPos(t, i, j)
    }

    fun calcPos(t: Float, i: Int, j:Int): Vec3 {
        val p1 = points[i]
        val p2 = points[j]
        val v1 = vectors[i] * diff
        val v2 = vectors[j] * diff
        val tMat = arrayOf(arrayOf(t*t*t, t*t, t, 1f))
        val hMat = arrayOf(
                arrayOf(2f, -2f, 1f, 1f),
                arrayOf(-3f, 3f, -2f, -1f),
                arrayOf(0f, 0f, 1f, 0f),
                arrayOf(1f, 0f, 0f, 0f)
        )
        val gMat = arrayOf(
                arrayOf(p1.x, p1.y, p1.z),
                arrayOf(p2.x, p2.y, p2.z),
                arrayOf(v1.x, v1.y, v1.z),
                arrayOf(v2.x, v2.y, v2.z)
        )
        val p = mult(tMat, mult(hMat, gMat))[0]
        return Vec3(p[0], p[1], p[2])
    }

    fun mult(m1: Array<Array<Float>>, m2: Array<Array<Float>>): Array<Array<Float>> {
        return Array(m1.size) {
            i -> Array(m2[0].size) {
                j -> Array(m2.size) {
                    m1[i][it]*m2[it][j]
                }.sum()
            }
        }
    }

    fun calcLeng(i: Int, j: Int): Float {
        return Array(detail) {
            val t1 = Function.linear(it, 0, 1, detail).toFloat()
            val t2 = Function.linear(it+1, 0, 1, detail).toFloat()
            val p1 = calcPos(t1, i, j)
            val p2 = calcPos(t2, i, j)
            length(p1-p2)
        }.sum()
    }

    fun drag() {
        if (mouseButton == LEFT) {
            val s = points.size
            points[draggingIndex] = Vec3(mouseX.toFloat(), mouseY.toFloat(), 0f)
            vectors[(draggingIndex-1+s)%s] = calcVec((draggingIndex-1+s)%s, (draggingIndex-2+s)%s, draggingIndex)
            vectors[draggingIndex] = calcVec(draggingIndex, (draggingIndex-1+s)%s, (draggingIndex+1)%s)
            vectors[(draggingIndex+1)%s] = calcVec((draggingIndex+1)%s, draggingIndex, (draggingIndex+2)%s)
        } else {
            dragging = false
        }
    }

}

fun main(args: Array<String>) = PApplet.main(App().javaClass.name)

data class Vec3(val x: Float, val y: Float, val z: Float)
operator fun Vec3.plus(rhs: Vec3)  : Vec3 = Vec3(x+rhs.x, y+rhs.y, z+rhs.z)
operator fun Vec3.minus(rhs: Vec3) : Vec3 = Vec3(x-rhs.x, y-rhs.y, z-rhs.z)
operator fun Vec3.times(rhs: Vec3) : Vec3 = Vec3(x*rhs.x, y*rhs.y, z*rhs.z)
operator fun Vec3.div(rhs: Vec3)   : Vec3 = Vec3(x/rhs.x, y/rhs.y, z/rhs.z)
operator fun Vec3.mod(rhs: Vec3)   : Vec3 = Vec3(x%rhs.x, y%rhs.y, z%rhs.z)
operator fun Vec3.plus(rhs: Float) : Vec3 = Vec3(x+rhs, y+rhs, z+rhs)
operator fun Vec3.minus(rhs: Float): Vec3 = Vec3(x-rhs, y-rhs, z-rhs)
operator fun Vec3.times(rhs: Float): Vec3 = Vec3(x*rhs, y*rhs, z*rhs)
operator fun Vec3.div(rhs: Float)  : Vec3 = Vec3(x/rhs, y/rhs, z/rhs)
operator fun Vec3.mod(rhs: Float)  : Vec3 = Vec3(x%rhs, y%rhs, z%rhs)
operator fun Float.plus(rhs: Vec3) : Vec3 = Vec3(this+rhs.x, this+rhs.y, this+rhs.z)
operator fun Float.minus(rhs: Vec3): Vec3 = Vec3(this-rhs.x, this-rhs.y, this-rhs.z)
operator fun Float.times(rhs: Vec3): Vec3 = Vec3(this*rhs.x, this*rhs.y, this*rhs.z)
operator fun Float.div(rhs: Vec3)  : Vec3 = Vec3(this/rhs.x, this/rhs.y, this/rhs.z)
operator fun Float.mod(rhs: Vec3)  : Vec3 = Vec3(this%rhs.x, this%rhs.y, this%rhs.z)
fun dot(v1: Vec3, v2: Vec3): Float = v1.x*v2.x + v1.y*v2.y + v1.z*v2.z
fun lengthSq(v: Vec3): Float = v.x*v.x + v.y*v.y + v.z*v.z
fun length(v: Vec3): Float = Math.sqrt(lengthSq(v).toDouble()).toFloat()
fun normalize(v: Vec3): Vec3 = v / length(v)