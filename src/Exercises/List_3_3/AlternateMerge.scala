package Exercises.List_3_3

object AlternateMerge extends App {
  def alternateMerge(listA: List[Any], listB: List[Any]): List[Any] = {
    def loopThrough(accum: List[Any], remainingA: List[Any], remainingB: List[Any]): List[Any] = {
      if(remainingA.isEmpty && remainingB.isEmpty) {
        return accum
      }

      var newAccum = accum

      if(!remainingA.isEmpty) {
        newAccum = newAccum :+ remainingA.head
      }

      if(!remainingB.isEmpty) {
        newAccum = newAccum :+ remainingB.head
      }

      val newRemainingA = if (remainingA.isEmpty) List() else remainingA.tail
      val newRemainingB = if (remainingB.isEmpty) List() else remainingB.tail

      loopThrough(newAccum, newRemainingA, newRemainingB)
    }

    loopThrough(List(), listA, listB) // start at second position, assume first element is the previous element
  }

  alternateMerge(List(), List(2, 4, 6))

  assert(alternateMerge(List(1, 3, 5), List(2, 4, 6)) == List(1,2,3,4,5,6))
  assert(alternateMerge(List(1,2,3), List(4,5,6)) == List(1,	4,	2,	5,	3,	6))
  assert(alternateMerge(List(), List(4,5,6)) == List(4, 5, 6))
  assert(alternateMerge(List(4, 5, 6), List()) == List(4, 5, 6))
  assert(alternateMerge(List(), List()) == List())
}