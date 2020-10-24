package Laboratories.Class_2

object AFunction {
  def a(m: Integer, n: Integer): Integer = {
    if(m == 0) {
      n + 1
    } else if(n == 0) {
      a(m - 1, 1)
    } else {
      a(m-1, a(m, n-1))
    }
  }

  def main(args: Array[String]): Unit = {
    println(a(2, 3)); // expect 9
    println(a(0, 100)); // expect 101
    println(a(3, 0)); // expect 5
  }
}