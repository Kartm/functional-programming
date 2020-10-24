package Laboratories.Class_3

object Combine extends App {
  def combine(stringList: List[String], separator: String): String = {
    def loop(accum: String, list: List[String]): String = {
      if (list.isEmpty) {
        return accum
      }
      else {
        val newString = if (list.length > 1) accum + list.head + separator else accum + list.head
        return loop(newString, list.tail)
      }
    }

    loop("", stringList)
  }

  val list = List("This","is", "string")
  println(combine(list, "-"))

  assert(combine (List("This","is", "string"),"-") == "This-is-string")
  assert(combine(List(), " asd ") == "")
  assert(combine(List("This","is", "string"), "") == "Thisisstring")
}