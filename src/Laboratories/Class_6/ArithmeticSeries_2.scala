package Laboratories.Class_6

object ArithmeticSeries_2 extends App {
  def arithmeticSeries(firstElement: Int, difference: Int): LazyList[Int] = {
    lazy val series : LazyList[Int] = firstElement #:: series.map(_ + difference)

    return series
  }

  println(arithmeticSeries(1, 1)(0))
  println(arithmeticSeries(1, 1)(1))
  println(arithmeticSeries(1, 1)(2))
  println(arithmeticSeries(1, 1)(3))
}