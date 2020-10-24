package Exercises.List_3_3

import scala.annotation.tailrec

object ReverseTailRecursion extends App {
  @tailrec
  def reverse(remainingValues: List[Any], accumulator: List[Any] = List()): List[Any] = {
    if(remainingValues.isEmpty) return accumulator

    reverse(remainingValues.tail, remainingValues.head :: accumulator )
  }

  println(reverse(List(1, 2, 3, 4, 5)))

  assert(reverse(List(1, 2, 3, 4, 5)) == List(5,4,3,2,1))
  assert(reverse(List(1)) == List(1))
  assert(reverse(List()) == List())
  assert(reverse(List(1, 4, 3, 2, 2)) == List(2,2,3,4,1))
}