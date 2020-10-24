package Exercises.List_1_2

object RecursiveSumArray {
  def sumArray(array: Array[Int]) = {
    def iterator(position: Int, accumulator: Int): Int =
      if (position != array.length) {
        iterator(position + 1, accumulator + array(position))
      } else {
        // no next element
        accumulator
      }

    iterator(0, 0)
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4)
    println(sumArray(array))
  }
}
