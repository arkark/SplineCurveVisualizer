package util

object Function {

    /* ============================================================================
        easing function
    -------------------------------------------------------------------------------

        t: current time
        b: start value
        c: change in value
        d: duration
        (t and d can be frames or seconds/milliseconds)

        references:
            http://gizma.com/easing/
            https://github.com/danro/jquery-easing/blob/master/jquery.easing.js

    ============================================================================ */


    // simple linear tweening - no easing, no acceleration
    fun linear(t: Double, b: Double, c: Double, d: Double): Double {
        return c*t/d + b
    }
    fun linear(t: Number, b: Number, c: Number, d: Number): Double
            = linear(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun linear(t: Number) = linear(t, 0, 1, 1)


    // quadratic easing in - accelerating from zero velocity
    fun easeInQuad(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d
        return c*_t*_t + b
    }
    fun easeInQuad(t: Number, b: Number, c: Number, d: Number): Double
            = easeInQuad(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInQuad(t: Number) = easeInQuad(t, 0, 1, 1)


    // quadratic easing out - decelerating to zero velocity
    fun easeOutQuad(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d
        return -c*_t*(_t-2) + b
    }
    fun easeOutQuad(t: Number, b: Number, c: Number, d: Number): Double
            = easeOutQuad(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeOutQuad(t: Number) = easeOutQuad(t, 0, 1, 1)


    // quadratic easing in/out - acceleration until halfway, then deceleration
    fun easeInOutQuad(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d*2
        return if (_t < 1) {
            c/2 * _t*_t + b
        } else {
            -c/2 * ((_t-1)*(_t-3)-1) + b
        }
    }
    fun easeInOutQuad(t: Number, b: Number, c: Number, d: Number): Double
            = easeInOutQuad(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInOutQuad(t: Number) = easeInOutQuad(t, 0, 1, 1)


    // cubic easing in - accelerating from zero velocity
    fun easeInCubic(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d
        return c * Math.pow(_t, 3.0) + b
    }
    fun easeInCubic(t: Number, b: Number, c: Number, d: Number): Double
            = easeInCubic(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInCubic(t: Number) = easeInCubic(t, 0, 1, 1)


    // cubic easing out - decelerating to zero velocity
    fun easeOutCubic(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d-1
        return c * (Math.pow(_t, 3.0) + 1) + b
    }
    fun easeOutCubic(t: Number, b: Number, c: Number, d: Number): Double
            = easeOutCubic(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeOutCubic(t: Number) = easeOutCubic(t, 0, 1, 1)


    // cubic easing in/out - acceleration until halfway, then deceleration
    fun easeInOutCubic(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d*2
        return if (_t < 1) {
            c/2 * Math.pow(_t, 3.0) + b
        } else {
            c/2 * (Math.pow(_t-2, 3.0) + 2) + b
        }
    }
    fun easeInOutCubic(t: Number, b: Number, c: Number, d: Number): Double
            = easeInOutCubic(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInOutCubic(t: Number) = easeInOutCubic(t, 0, 1, 1)


    // quartic easing in - accelerating from zero velocity
    fun easeInQuart(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d
        return c * Math.pow(_t, 4.0) + b
    }
    fun easeInQuart(t: Number, b: Number, c: Number, d: Number): Double
            = easeInQuart(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInQuart(t: Number) = easeInQuart(t, 0, 1, 1)


    // quartic easing out - decelerating to zero velocity
    fun easeOutQuart(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d - 1
        return -c * (Math.pow(_t, 4.0) - 1) + b
    }
    fun easeOutQuart(t: Number, b: Number, c: Number, d: Number): Double
            = easeOutQuart(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeOutQuart(t: Number) = easeOutQuart(t, 0, 1, 1)


    // quartic easing in/out - acceleration until halfway, then deceleration
    fun easeInOutQuart(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d*2
        return if (_t < 1) {
            c/2 * Math.pow(_t, 4.0) + b
        } else {
            -c/2 * (Math.pow(_t-2, 4.0) - 2) + b
        }
    }
    fun easeInOutQuart(t: Number, b: Number, c: Number, d: Number): Double
            = easeInOutQuart(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInOutQuart(t: Number) = easeInOutQuart(t, 0, 1, 1)


    // quintic easing in - accelerating from zero velocity
    fun easeInQuint(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d
        return c * Math.pow(_t, 5.0) + b
    }
    fun easeInQuint(t: Number, b: Number, c: Number, d: Number): Double
            = easeInQuint(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInQuint(t: Number) = easeInQuint(t, 0, 1, 1)


    // quintic easing out - decelerating to zero velocity
    fun easeOutQuint(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d - 1
        return c * (Math.pow(_t, 5.0) + 1) + b
    }
    fun easeOutQuint(t: Number, b: Number, c: Number, d: Number): Double
            = easeOutQuint(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeOutQuint(t: Number) = easeOutQuint(t, 0, 1, 1)


    // quintic easing in/out - acceleration until halfway, then deceleration
    fun easeInOutQuint(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d*2
        return if (_t < 1) {
            c/2 * Math.pow(_t, 5.0) + b
        } else {
            c / 2 * (Math.pow(_t-2, 5.0) + 2) + b
        }
    }
    fun easeInOutQuint(t: Number, b: Number, c: Number, d: Number): Double
            = easeInOutQuint(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInOutQuint(t: Number) = easeInOutQuint(t, 0, 1, 1)


    // sinusoidal easing in - accelerating from zero velocity
    fun easeInSine(t: Double, b: Double, c: Double, d: Double): Double {
        return -c * Math.cos(t/d * Math.PI/2) + c + b
    }
    fun easeInSine(t: Number, b: Number, c: Number, d: Number): Double
            = easeInSine(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInSine(t: Number) = easeInSine(t, 0, 1, 1)


    // sinusoidal easing out - decelerating to zero velocity
    fun easeOutSine(t: Double, b: Double, c: Double, d: Double): Double {
        return c * Math.sin(t/d * Math.PI/2) + b
    }
    fun easeOutSine(t: Number, b: Number, c: Number, d: Number): Double
            = easeOutSine(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeOutSine(t: Number) = easeOutSine(t, 0, 1, 1)


    // sinusoidal easing in/out - accelerating until halfway, then decelerating
    fun easeInOutSine(t: Double, b: Double, c: Double, d: Double): Double {
        return -c/2 * (Math.cos(Math.PI*t/d) - 1) + b
    }
    fun easeInOutSine(t: Number, b: Number, c: Number, d: Number): Double
            = easeInOutSine(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInOutSine(t: Number) = easeInOutSine(t, 0, 1, 1)


    // exponential easing in - accelerating from zero velocity
    fun easeInExpo(t: Double, b: Double, c: Double, d: Double): Double {
        return c*Math.pow(2.0, 10*(t/d - 1)) + b
    }
    fun easeInExpo(t: Number, b: Number, c: Number, d: Number): Double
            = easeInExpo(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInExpo(t: Number) = easeInExpo(t, 0, 1, 1)


    // exponential easing out - decelerating to zero velocity
    fun easeOutExpo(t: Double, b: Double, c: Double, d: Double): Double {
        return c * (-Math.pow(2.0, -10*t/d) + 1) + b
    }
    fun easeOutExpo(t: Number, b: Number, c: Number, d: Number): Double
            = easeOutExpo(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeOutExpo(t: Number) = easeOutExpo(t, 0, 1, 1)


    // exponential easing in/out - accelerating until halfway, then decelerating
    fun easeInOutExpo(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d*2
        return if (_t < 1) {
            c/2 * Math.pow(2.0, 10*(_t-1)) + b
        } else {
            c/2 * (-Math.pow(2.0, -10*(_t-1)) + 2) + b
        }
    }
    fun easeInOutExpo(t: Number, b: Number, c: Number, d: Number): Double
            = easeInOutExpo(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInOutExpo(t: Number) = easeInOutExpo(t, 0, 1, 1)


    // circular easing in - accelerating from zero velocity
    fun easeInCirc(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d
        return -c * (Math.sqrt(1 - _t*_t) - 1) + b
    }
    fun easeInCirc(t: Number, b: Number, c: Number, d: Number): Double
            = easeInCirc(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInCirc(t: Number) = easeInCirc(t, 0, 1, 1)


    // circular easing out - decelerating to zero velocity
    fun easeOutCirc(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d - 1
        return c * Math.sqrt(1 - _t*_t) + b
    }
    fun easeOutCirc(t: Number, b: Number, c: Number, d: Number): Double
            = easeOutCirc(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeOutCirc(t: Number) = easeOutCirc(t, 0, 1, 1)


    // circular easing in/out - acceleration until halfway, then deceleration
    fun easeInOutCirc(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d*2
        return if (_t < 1) {
            -c/2 * (Math.sqrt(1 - _t*_t) - 1) + b
        } else {
            c/2 * (Math.sqrt(1 - (_t-2)*(_t-2)) + 1) + b
        }
    }
    fun easeInOutCirc(t: Number, b: Number, c: Number, d: Number): Double
            = easeInOutCirc(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInOutCirc(t: Number) = easeInOutCirc(t, 0, 1, 1)


    fun easeInBack(t: Double, b: Double, c: Double, d: Double, s: Double = 1.70158): Double {
        val _t = t/d
        return c*_t*_t*((s+1)*_t - s) + b;
    }
    fun easeInBack(t: Number, b: Number, c: Number, d: Number, s:Number = 1.70158): Double
            = easeInBack(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble(), s.toDouble())
    fun easeInBack(t: Number, s: Double = 1.70158) = easeInBack(t, 0, 1, 1, s)


    fun easeOutBack(t: Double, b: Double, c: Double, d: Double, s: Double = 1.70158): Double {
        val _t = t/d-1
        return c*(_t*_t*((s+1)*_t + s) + 1) + b;
    }
    fun easeOutBack(t: Number, b: Number, c: Number, d: Number, s:Number = 1.70158): Double
            = easeOutBack(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble(), s.toDouble())
    fun easeOutBack(t: Number, s: Double = 1.70158) = easeOutBack(t, 0, 1, 1, s)

    fun easeInOutBack(t: Double, b: Double, c: Double, d: Double, s: Double = 1.70158): Double {
        val _t = t/d*2
        val _s = s*1.525
        return if (_t < 1) {
            c/2 * (_t*_t*((_s + 1)*_t-_s)) + b
        } else {
            c/2*((_t-2)*(_t-2)*((_s+1)*(_t-2)+_s) + 2) + b;
        }
    }
    fun easeInOutBack(t: Number, b: Number, c: Number, d: Number, s:Number = 1.70158): Double
            = easeInOutBack(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble(), s.toDouble())
    fun easeInOutBack(t: Number, s: Double = 1.70158) = easeInOutBack(t, 0, 1, 1, s)


    fun easeInElastic(t: Double, b: Double, c: Double, d: Double): Double {
        if (t == 0.0) return b
        if (t == d)   return b+c
        val p = d*0.3
        val a = c
        val s = if (a < Math.abs(c)) p/4 else p/(2*Math.PI) * Math.asin(c/a)
        val _t = t/d-1
        return -(a*Math.pow(2.0,10*_t) * Math.sin((_t*d-s)*(2*Math.PI)/p)) + b;
    }
    fun easeInElastic(t: Number, b: Number, c: Number, d: Number): Double
            = easeInElastic(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInElastic(t: Number) = easeInElastic(t, 0, 1, 1)


    fun easeOutElastic(t: Double, b: Double, c: Double, d: Double): Double {
        if (t == 0.0) return b
        if (t == d)   return b+c
        val p = d*0.3
        val a = c
        val s = if (a < Math.abs(c)) p/4 else p/(2*Math.PI) * Math.asin(c/a)
        val _t = t/d
        return a * Math.pow(2.0, -10*_t) * Math.sin((_t*d-s) * (2*Math.PI) / p) + c + b
    }
    fun easeOutElastic(t: Number, b: Number, c: Number, d: Number): Double
            = easeOutElastic(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeOutElastic(t: Number) = easeOutElastic(t, 0, 1, 1)


    fun easeInOutElastic(t: Double, b: Double, c: Double, d: Double): Double {
        if (t == 0.0) return b
        if (t == d)   return b+c
        val p = d*0.3*1.5
        val a = c
        val s = if (a < Math.abs(c)) p/4 else p/(2*Math.PI) * Math.asin(c/a)
        val _t = t/d*2
        return if (_t < 1) {
            -0.5*a*Math.pow(2.0, 10*(_t-1)) * Math.sin(((_t-1)*d-s)*(2*Math.PI)/p) + b
        } else {
            0.5*a*Math.pow(2.0, -10*(_t-1)) * Math.sin(((_t-1)*d-s)*(2*Math.PI)/p) + c + b
        }
    }
    fun easeInOutElastic(t: Number, b: Number, c: Number, d: Number): Double
            = easeInOutElastic(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInOutElastic(t: Number) = easeInOutElastic(t, 0, 1, 1)


    fun easeInBounce(t: Double, b: Double, c: Double, d: Double): Double {
        return c - easeOutBounce(d-t, 0, c, d) + b
    }
    fun easeInBounce(t: Number, b: Number, c: Number, d: Number): Double
            = easeInBounce(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInBounce(t: Number) = easeInBounce(t, 0, 1, 1)


    fun easeOutBounce(t: Double, b: Double, c: Double, d: Double): Double {
        val _t = t/d
        return if (_t < 1/2.75) {
            return c*(7.5625*_t*_t) + b;
        } else if (_t < 2/2.75) {
            return c*(7.5625*(_t-1.5/2.75)*(_t-1.5/2.75) + 0.75) + b;
        } else if (_t < 2.5/2.75) {
            return c*(7.5625*(_t-2.25/2.75)*(_t-2.25/2.75) + 0.9375) + b;
        } else {
            return c*(7.5625*(_t-2.625/2.75)*(_t-2.625/2.75) + 0.984375) + b;
        }
    }
    fun easeOutBounce(t: Number, b: Number, c: Number, d: Number): Double
            = easeOutBounce(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeOutBounce(t: Number) = easeOutBounce(t, 0, 1, 1)


    fun easeInOutBounce(t: Double, b: Double, c: Double, d: Double): Double {
        return if (t < d/2) {
            0.5 * easeInBounce(t*2, 0, c, d) + b
        } else {
            0.5 * easeOutBounce(t*2-d, 0, c, d) + c*0.5 + b
        }
    }
    fun easeInOutBounce(t: Number, b: Number, c: Number, d: Number): Double
            = easeInOutBounce(t.toDouble(), b.toDouble(), c.toDouble(), d.toDouble())
    fun easeInOutBounce(t: Number) = easeInOutBounce(t, 0, 1, 1)


    /* ============================================================================
        util function
    -------------------------------------------------------------------------------
    references:
        http://www.iquilezles.org/www/articles/functions/functions.htm
    ============================================================================ */

    // f(x) = k*x*e^(1-kx)
    fun impulse(x: Double, k: Double): Double {
        val h = k*x
        return h*Math.exp(1 - h)
    }
    fun impulse(x: Number, k: Number) = impulse(x.toDouble(), k.toDouble())


    // f(x) = (4*x*(1-x))^k
    fun parabola(x: Double, k: Double): Double {
        return Math.pow(4*x*(1-x), k)
    }
    fun parabola(x: Number, k: Number): Double = parabola(x.toDouble(), k.toDouble())


    // k = (a+b)^(a+b) / (a^a * b^b)
    // f(x) = k * x^a * (1-x)^b
    fun powerCurve(x: Double, a: Double, b: Double): Double {
        val k = Math.pow(a+b, a+b) / ( Math.pow(a, a)*Math.pow(b, b) )
        return k * Math.pow(x, a) * Math.pow(1-x, b)
    }
    fun powerCurve(x: Number, a: Number, b: Number): Double = powerCurve(x.toDouble(), a.toDouble(), b.toDouble())



}