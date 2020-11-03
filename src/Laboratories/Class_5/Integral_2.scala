package Laboratories.Class_5

object Integral_2 extends App {
  def integral(function: Double => Double, interval: (Double, Double), subintervals: Double): Double = {
    val (a, b) = interval

    val deltaX = (b-a)/subintervals

    // sum from left to right
    def sum(accum: Double, left: Double): Double = {
      if(left + deltaX > b) {
        return accum
      }

      val value = deltaX * 0.5 * (function(left) + function(left + deltaX))
      sum(accum + value, left + deltaX)
    }

    sum(0, a)
  }

  def someLinear(x: Double): Double = {
    return x * 2 + 1
  }

  def someQuadratic(x: Double): Double = {
    return x*x + 2*x + 1
  }

  println(integral(someLinear, (0.0, 1.1), 10000))
  println(integral(someQuadratic, (0, 1.1), 10000))
}