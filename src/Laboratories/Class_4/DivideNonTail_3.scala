package Laboratories.Class_4

import scala.math.pow

object DivideNonTail_3 extends App {
  def divide(list: List[Int]): (List[Int], List[Int]) = {
    def loopThrough(remaining: List[Int]): List[(Boolean, Int)] = {
      if (remaining.length == 1) {
        return List((remaining.head % 2 == 0, remaining.head))
      } else if (remaining.isEmpty){
        return List()
      }

      loopThrough(remaining.tail) :+ (remaining.head % 2 == 0, remaining.head)
    }

    val markedValues = loopThrough(list)

    var even = List[Int]();
    var odd = List[Int]();

    for ((i) <- markedValues) {
      val isEven = i._1
      val value = i._2

      if(isEven) {
        even = pow(value, 2).toInt :: even
      } else {
        odd = value * 3 :: odd
      }
    }

    return (even, odd)
  }

  println(divide(List(1, 2, 3, 4, 5, 6)))

  assert(divide (List(3,6,8,9,13)) == (List(36,64), List(9,27, 39)))
  assert(divide (List()) == (List(), List()))
  assert(divide (List(3, 5, 7, 9)) == (List(), List(9, 15, 21, 27)))
  assert(divide (List(2, 4, 8)) == (List(4, 16, 64), List()))
}