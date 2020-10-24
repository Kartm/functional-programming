package Exercises.List_3_3

object ReverseWithoutTailRecursion extends App {
  def reverse(remainingValues: List[Any]): List[Any] = {
    if(remainingValues.isEmpty) {
      return List()
    }

    return reverse(remainingValues.tail) :+ remainingValues.head
  }

  println(reverse(List(1, 2, 3, 4, 5)))

  assert(reverse(List(1, 2, 3, 4, 5)) == List(5,4,3,2,1))
  assert(reverse(List(1)) == List(1))
  assert(reverse(List()) == List())
  assert(reverse(List(1, 4, 3, 2, 2)) == List(2,2,3,4,1))
}