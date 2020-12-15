package Laboratories.Class_10

/*
Write a function to combine the given two lists of integers into a list of numbers.

    Items in the output list will be the sum of numbers from the first list and the second list. If the lists differ in length, fill in the missing number with 0.

     Write a function using tail and non-tail recursion.



    Example:

    call: call (List(5, 4, 3, 2), List(1, 2, 3, 4, 5, 6)) ;

    result: List (6, 6, 6, 6, 5, 6)



    Points: 8 (Scala language) - 4 for the tail recursion version and 4 for the non-tail recursion version
 */

object Class_4_Task_2_NonTail extends App {
  def combine(listA: List[Int], listB: List[Int]): List[Int] = {
    def loopThrough(remainingA: List[Int], remainingB: List[Int]): List[Int] = {
      if(remainingA.isEmpty && remainingB.isEmpty) {
        return List()
      }

      var appendedVal =
        if(remainingA.isEmpty) remainingB.head
        else if(remainingB.isEmpty) remainingA.head
        else (remainingA.head + remainingB.head) // both non-empty

      val newRemainingA = if (remainingA.isEmpty) List() else remainingA.tail
      val newRemainingB = if (remainingB.isEmpty) List() else remainingB.tail

      appendedVal :: loopThrough(newRemainingA, newRemainingB)
    }

    loopThrough(listA, listB)
  }

  println(combine(List(5, 4, 3, 2), List(1, 2, 3, 4, 5, 6)))

  assert(combine(List(5, 4, 3, 2), List(1, 2, 3, 4, 5, 6)) == List(6, 6, 6, 6, 5, 6))
  assert(combine(List(5, 4, 3, 2), List()) == List(5, 4, 3, 2))
  assert(combine(List(), List(1, 2, 3, 4)) == List(1, 2, 3, 4))
  assert(combine(List(), List()) == List())
}