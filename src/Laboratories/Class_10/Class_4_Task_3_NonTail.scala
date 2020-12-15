package Laboratories.Class_10

import scala.math.pow

/*
1Write a function that divides the input list into two sub-lists.

The first sub-list will contain all even-valued elements. In addition, all elements on the first sub-list are to be raised to power of 2.

The second sub-list is to contain all elements with odd values. In addition, all elements on the second sub-list are to be multiplied by 3.

The order of the elements must be saved. Return the result as a pair of lists.

Write a function using tail and non-tail recursion.


Example:

calling: divide (List(3,6,8,9,13))

result: (List(36,64), List(9,27, 39))


Points: 8 (Scala language) - 4 for the version with tail recursion and 4 for the version with non-tail recursion
 */

object Class_4_Task_3_NonTail extends App {
  def divide(list: List[Int]): (List[Int], List[Int]) = {
    def splitList(remaining: List[Int], evenAccum: List[Int], oddAccum: List[Int]): (List[Int], List[Int]) = {
      if(remaining.isEmpty) {
        return (List[Int](), List[Int]())
      }

      val splitted = splitList(remaining.tail, evenAccum, oddAccum)

      val evenList = if(remaining.head % 2 == 0) List(pow(remaining.head, 2).toInt) ::: splitted._1  else splitted._1
      val oddList = if(remaining.head % 2 == 1) List(remaining.head * 3) ::: splitted._2 else splitted._2

      (evenAccum ::: evenList, oddAccum ::: oddList)
    }

    splitList(list, List(), List())
  }

  println(divide(List(1, 2, 3, 4, 5, 6)))

  assert(divide (List(3,6,8,9,13)) == (List(36,64), List(9,27, 39)))
  assert(divide (List()) == (List(), List()))
  assert(divide (List(3, 5, 7, 9)) == (List(), List(9, 15, 21, 27)))
  assert(divide (List(2, 4, 8)) == (List(4, 16, 64), List()))
}