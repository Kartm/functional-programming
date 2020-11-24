package Laboratories.Class_8

object Multiply_1 extends App {
  def multiplicate(elements: LazyList[Int], repetitions: LazyList[Int]): LazyList[Int] = {
    elements.zip(repetitions).flatMap{case(element, n) => LazyList.fill(n)(element)}
  }

  // expect (2, 2, 2, 3)
  println(multiplicate(LazyList(1, 2, 3), LazyList (0, 3, 1, 4)).take(20).toList)

  // testing with finite streams
  assert(multiplicate(LazyList(1, 2, 3), LazyList (0, 3, 1, 4)).take(20).toList == List(2, 2, 2, 3))
  assert(multiplicate(LazyList(1, 2, 3), LazyList (0, 0, 0)).take(20).toList == List())
  assert(multiplicate(LazyList(1, 2, 3), LazyList ()).take(20).toList == List())
  assert(multiplicate(LazyList(), LazyList (0, 3, 1, 4)).take(20).toList == List())

  // testing with an infinite stream
  lazy val naturals : LazyList[Int] = 1 #:: naturals.map(_ + 1)
  println(multiplicate(naturals, naturals).take(22).toList)

  // tested up to x = 6
  assert(multiplicate(naturals, naturals).take(21).toList == List(1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6))
}