package Exercises.List_2_3

object FibonacciRecursive extends App {
  // counts	number of	occurrences	of specific	element	in the list.
  def fibonacci(n: Int): Int = {
    def loop(accum: Int, n: Int): Int = {
      if (n == 0) {
        return accum
      }
      else if (n == 1) {
        return accum + 1
      }
      else {
        return loop(accum, n - 1) + loop(accum, n-2)
      }
    }

    loop(0, n)
  }

  println(fibonacci(7))

  assert(fibonacci(0) == 0)
  assert(fibonacci(1) == 1)
  assert(fibonacci(2) == 1)
  assert(fibonacci(3) == 2)
  assert(fibonacci(4) == 3)
  assert(fibonacci(5) == 5)
  assert(fibonacci(6) == 8)
  assert(fibonacci(7) == 13)
  assert(fibonacci(20) == 6765)
}