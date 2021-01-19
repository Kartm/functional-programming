package Laboratories.Class_6

object OddSeries_3 extends App {
  def oddSeries(start: Int): LazyList[Int] = {
    lazy val naturals : LazyList[Int] = 1 #:: naturals.map(_ + 1)

    return naturals.filter(x => x % 2 != 0 && x >= start)
  }

  println(oddSeries(12)(0))
  println(oddSeries(12)(1))
  println(oddSeries(12)(2))
  println(oddSeries(12)(3))
}