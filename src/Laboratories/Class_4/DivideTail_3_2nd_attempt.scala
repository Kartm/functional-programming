package Laboratories.Class_4

import scala.math.pow

object DivideTail_3_2nd_attempt extends App {
  def divide(list: List[Int]): (List[Int], List[Int]) = {
    def loopThrough(remaining: List[Int], even: List[Int] = List(), odd: List[Int]= List()): (List[Int], List[Int]) = {
      if (remaining.isEmpty) {
        return (even, odd)
      } else {
        val newOdd = if(remaining.head % 2 != 0) odd :+ (remaining.head * 3) else odd
        val newEven = if(remaining.head % 2 == 0) (even :+ pow(remaining.head, 2).toInt) else even

        loopThrough(remaining.tail, newEven, newOdd)
      }
    }

    loopThrough(list)
  }

  println(divide(List(1, 2, 3, 4, 5, 6)))

  assert(divide (List(3,6,8,9,13)) == (List(36,64), List(9,27, 39)))
  assert(divide (List()) == (List(), List()))
  assert(divide (List(3, 5, 7, 9)) == (List(), List(9, 15, 21, 27)))
  assert(divide (List(2, 4, 8)) == (List(4, 16, 64), List()))
}