package Laboratories.Class_4

import scala.math.pow

object DivideTail_3 extends App {
  def divide(list: List[Int]): (List[Int], List[Int]) = {
    def loopThrough(remaining: List[Int], accumEven: List[Int] = List(), accumOdd: List[Int]= List()): (List[Int], List[Int]) = {
      if (remaining.isEmpty) {
        return (accumEven, accumOdd)
      }

      var newAccumOdd = accumOdd
      var newAccumEven = accumEven

      if(remaining.head % 2 == 0) {
        newAccumEven = (newAccumEven :+ pow(remaining.head, 2).toInt)
      } else {
        newAccumOdd = newAccumOdd :+ (remaining.head * 3)
      }

      loopThrough(remaining.tail, newAccumEven, newAccumOdd )
    }

    loopThrough(list)
  }

  println(divide(List(1, 2, 3, 4, 5, 6)))

  assert(divide (List(3,6,8,9,13)) == (List(36,64), List(9,27, 39)))
  assert(divide (List()) == (List(), List()))
  assert(divide (List(3, 5, 7, 9)) == (List(), List(9, 15, 21, 27)))
  assert(divide (List(2, 4, 8)) == (List(4, 16, 64), List()))
}