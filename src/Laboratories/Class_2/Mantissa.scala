package Laboratories.Class_2

object Mantissa {
  def mantissa(num: Double) = {
    // below code causes 0.3999999999999999
    // num - num.toInt

    val strResult = "0." + num.abs.toString.split("\\.")(1)
    strResult.toDouble
  }

  def main(args: Array[String]): Unit = {
    println(mantissa(3.4)); // expect 0.4
    println(mantissa(0)); // expect 0.0
    println(mantissa(3.1415926535)); // expect 0.1415926535
    println(mantissa(100)); // expect 0.0
  }
}