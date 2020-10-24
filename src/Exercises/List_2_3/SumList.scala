package Exercises.List_2_3

object SumList extends App {
  // recursively	sum	the	odd	values	in	a	list
  def sumList(list: List[Int]): Int = {
    def loop(accum: Int, list: List[Int]): Int = {
      if (list.isEmpty) {
        return accum
      }
      else {
        val newSum = if (list.head % 2 != 0) accum + list.head else accum
        return loop(newSum, list.tail)
      }
    }

    loop(0, list)
  }

  val list = List(1, 2, 3, 4, 5, 6)
  println(sumList(list))

  assert(sumList(List()) == 0)
  assert(sumList(List(1)) == 1)
  assert(sumList(List(1, 2, 3, 4, 5, 6)) == 9)
  assert(sumList(List(2, 12, 400, 800)) == 0)
  assert(sumList(List(1, 3, 5, 7, 9, 11)) == 36)
}