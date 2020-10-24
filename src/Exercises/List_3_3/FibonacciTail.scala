package Exercises.List_3_3

import scala.annotation.tailrec

object FibonacciTail extends App {
  @tailrec
  def fibonacciTail(n: Int, a:Int = 0, b:Int = 1): Int = {
    if(n == 0) {
      return a
    } else if (n == 1) {
      return b
    }

    return fibonacciTail(n - 1, b, a+ b)
  }

  println(fibonacciTail(5)) // 0 + 1 + 1 + 2 + 3

  assert(fibonacciTail(0) == 0)
  assert(fibonacciTail(1) == 1)
  assert(fibonacciTail(2) == 1)
  assert(fibonacciTail(3) == 2)
  assert(fibonacciTail(4) == 3)
  assert(fibonacciTail(5) == 5)
  assert(fibonacciTail(20) == 6765)
  assert(fibonacciTail(31) == 1346269)
}