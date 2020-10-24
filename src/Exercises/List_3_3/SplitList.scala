package Exercises.List_3_3

object SplitList extends App {
  def splitList(list: List[Int]): List[List[Int]] = {
    def loopThrough(remaining: List[Int], accumOdd: List[Int]= List(), accumEven: List[Int] = List()): List[List[Int]] = {
      if (remaining.isEmpty) {
        return List(accumOdd, accumEven)
      }

      var newAccumOdd = accumOdd
      var newAccumEven = accumEven

      if(remaining.head % 2 == 0) {
        newAccumEven = newAccumEven :+ remaining.head
      } else {
        newAccumOdd = newAccumOdd :+ remaining.head
      }

      loopThrough(remaining.tail, newAccumOdd, newAccumEven)
    }

    loopThrough(list)
  }

  println(splitList(List(1, 2, 3, 4, 5, 6)))

  assert(splitList(List(1, 2, 3, 4, 5, 6)) == List(List(1, 3, 5), List(2, 4, 6)))
  assert(splitList(List(1, 3, 5, 7)) == List(List(1, 3, 5, 7), List()))
  assert(splitList(List(2, 20, 200, 400)) == List(List(), List(2, 20, 200, 400)))
  assert(splitList(List()) == List(List(), List()))
}