package Exercises.List_3_3

import scala.annotation.tailrec

object Reverse extends App {
  def reverse(originalList: List[Any]) = {
    @tailrec
    def loop(remainingValues: List[Any], accumulator: List[Any]): List[Any] = {
      if(remainingValues.isEmpty)
        return accumulator

      val newAccumulator = remainingValues.head :: accumulator

      loop(remainingValues.tail, newAccumulator)
    }

    loop(originalList, List())
  }

  println(reverse(List(1, 2, 3, 4, 5)))
}