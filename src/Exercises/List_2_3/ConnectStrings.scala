package Exercises.List_2_3

object ConnectStrings extends App {
  // returns strings connected	b	a	separator
  def connectStrings(originalList: List[String], separator: String): String = {
    def loop(accum: String, list: List[String]): String = {
      if (list.isEmpty) {
        return accum
      }
      else {
        val newString = if (list.length > 1) accum + list.head + separator else accum + list.head
        // tail returns all elements except the first
        return loop(newString, list.tail)
      }
    }

    loop("", originalList)
  }

  val list = List("Some", "example", "sentence")
  println(connectStrings(list, ","))

  assert(connectStrings(list, ",") == "Some,example,sentence")
  assert(connectStrings(list, " asd ") == "Some asd example asd sentence")
  assert(connectStrings(list, "") == "Someexamplesentence")
}