package Laboratories.Class_4

object SubtractTailSum_1 extends App {
  def subtractTailSum(list: List[Int]): Int = {
    require(list.length >= 1, "List must have a minimum length of 1")

    def loopThrough(accum: Int, remaining: List[Int]): Int = {
      if (remaining.isEmpty) {
        return accum
      }

      loopThrough(accum + remaining.head, remaining.tail)
    }

    val tailSum = loopThrough(0, list)

    return list.head - (tailSum - list.head)
  }

  println(subtractTailSum(List(1, 2)))

  assert(subtractTailSum(List(1)) == 1)
  assert(subtractTailSum(List(1, 2)) == -1)
  assert(subtractTailSum(List(1, 2, 3)) == -4)
  assert(subtractTailSum(List(1, 1)) == 0)
}