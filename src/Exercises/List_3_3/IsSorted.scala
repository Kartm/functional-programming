package Exercises.List_3_3

import scala.annotation.tailrec

object IsSorted extends App {
  def isSorted(list: List[Double], expectAscending: Boolean): Boolean = {
    if(list.length <= 1) {
      return true
    }

    @tailrec
    def loopThrough(currentIndex: Int): Boolean = {
      val previousElement = list(currentIndex - 1)
      val currentElement = list(currentIndex)

      val validOrder = if(expectAscending) previousElement <= currentElement else previousElement >= currentElement

      if(!validOrder) {
        return false
      }

      if(currentIndex == list.length - 1) { // reached the end, everything is fine
        return true;
      }

      loopThrough(currentIndex + 1)
    }

    loopThrough(1) // start at second position, first element is the previous element
  }

  isSorted(List(1, 2, 3), true)

  assert(isSorted(List(1, 2, 3), true))
  assert(isSorted(List(1, 2, 3), false) == false)
  assert(isSorted(List(1, 3, 2), true) == false)
  assert(isSorted(List(3, 1, 2), false) == false)
  assert(isSorted(List(3, 2, 1), false) == true)
  assert(isSorted(List(3), false) == true)
  assert(isSorted(List(3), true) == true)
  assert(isSorted(List(), false) == true)
  assert(isSorted(List(), true) == true)
}