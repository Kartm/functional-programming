package Exercises.List_4

import scala.math.sqrt

object Sieve extends App {
  def getPrimes(maxNumber: Int): List[Int] = {
    def sieve(originalList: List[Int], end: Int): List[Int] = originalList match {
      case Nil => Nil // an empty list
      case x :: list if x <= end => x :: sieve(originalList.filter(_ % x != 0), end) // remove multiples of x
      case _ => originalList // reached the end
    }

    sieve((2 to maxNumber).toList, sqrt(maxNumber).toInt)
  }

  getPrimes(100).foreach(x => printf("%d ", x))

  assert(getPrimes(1) == List())
  assert(getPrimes(2) == List(2))
  assert(getPrimes(10) == List(2, 3, 5, 7))
  assert(getPrimes(30) == List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))
}