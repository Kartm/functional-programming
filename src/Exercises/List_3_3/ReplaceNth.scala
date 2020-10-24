package Exercises.List_3_3

import scala.annotation.tailrec

object ReplaceNth extends App {
  def replaceNth(originalList: List[Any], n: Int, x: Any): List[Any] = {
    require(n >= 0, "The value of n must be positive!")
    require(n < originalList.length, "The value of n must be within the length of the list!")

    @tailrec
    def loopThrough(accumulator: List[Any], currentIndex: Int): List[Any] = {
      if(accumulator.length == originalList.length) { // we have copied the list, finish
        return accumulator
      }

      val newAccumulator = if (accumulator.length == n) accumulator :+ x else accumulator :+ originalList(currentIndex)

      loopThrough(newAccumulator, currentIndex + 1)
    }

    loopThrough(List(), 0)
  }

  replaceNth(List(1, 2, 3), 1, 100)

  assert(replaceNth(List(1, 2, 3), 1, 100) == List(1, 100, 3))
  assert(replaceNth(List(1, 2, 3), 0, 100) == List(100, 2, 3))
  assert(replaceNth(List(1, 2, 3), 2, 100) == List(1, 2, 100))
}