package Laboratories.Class_5

object GrayCode_1 extends App {
  def prefixList(list: List[String], prefix: String): List[String] = list match {
    case s :: rest => prefix + s :: prefixList(rest, prefix)
    case _ => Nil
  }

  def grayCode(bits: Int): List[String] = {
    require(bits > 0)

    def constructCode(code: List[String], i: Int): List[String] = {
      if(i >= bits) return code

      val newEntries = prefixList(code.reverse, "1")
      val oldEntries = prefixList(code, "0")

      constructCode(oldEntries ::: newEntries, i + 1)
    }

    // construct recursively
    constructCode(List("0", "1"), 1)
  }

  println(grayCode(1))
  println(grayCode(2))
  println(grayCode(3))

  assert(prefixList(List("0", "1", "2"), "X") == List("X0", "X1", "X2"))
  assert(grayCode(1) == List("0", "1"))
  assert(grayCode(2) == List("00", "01", "11", "10"))
  assert(grayCode(3) == List("000", "001", "011", "010", "110", "111", "101", "100"))
}