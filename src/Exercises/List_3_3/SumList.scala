package Exercises.List_3_3

import scala.annotation.tailrec

object SumList extends App {
  // returns strings connected	b	a	separator
  def sumList(list: List[Int], n: Int): Int = {
    @tailrec
    def sum(index: Int, acc: Int): Int = n match {
      case _ if index == n => acc
      case _ => sum(index + 1, list(index) + acc)
    }

    sum(0, 0)
  }

  val list = List(1, 2, 3, 4)
  println(sumList(list, list.length))

  assert(sumList(List(), 0) == 0)
  assert(sumList(List(1, 2, 3, 4), list.length) == 10)
  assert(sumList(List(4), 1) == 4)
}