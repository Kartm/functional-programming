package Laboratories.Class_2

object ModFunction {
  def fun(a: Integer, b: Integer): Integer = {
    if(b == 0) {
      a
    } else {
      fun(b, a % b)
    }
  }

  def main(args: Array[String]): Unit = {
    println(fun(2, 3)); // expect 1
    println(fun(7, 13)); // expect 1
    println(fun(2, 4)); // expect 2
    println(fun(100, 5)); // expect 5
  }
}