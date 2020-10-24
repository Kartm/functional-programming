package Exercises.List_2_3

object CountOccurrences extends App {
  // counts	number of	occurrences	of specific	element	in the list.
  def countOccurrences(originalList: List[Any], element: Any): Int = {
    def loop(accum: Int, list: List[Any]): Int = {
      if (list.isEmpty) {
        return accum
      }
      else {
        return loop(if(list.head.equals(element)) accum + 1 else accum, list.tail)
      }
    }

    loop(0, originalList)
  }

  val list = List("Some", "example", "sentence")
  println(countOccurrences(list, "Some"))

  assert(countOccurrences(list, "Some") == 1)
  assert(countOccurrences(list, "Nonexistingitem") == 0)
  assert(countOccurrences(List(1, 2, 2, 2, 2, 3), 2) == 4)
  assert(countOccurrences(List(), 20) == 0)
}