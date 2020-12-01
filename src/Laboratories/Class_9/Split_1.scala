package Laboratories.Class_9
import scala.annotation.tailrec

object Split_1 extends App {
  // functional way
  def splitFunctional(originalElements: List[Any]): (List[Any], List[Any]) = {
    @tailrec
    def innerSplit(currentElements: List[Any], oddList: List[Any], evenList: List[Any]): (List[Any], List[Any]) = currentElements match {
      case Nil => (oddList, evenList)
      case head::rest => {
        val index = originalElements.indexOf(head)
        val newOddList = if(index % 2 != 0) oddList else oddList:+head
        val newEvenList = if(index % 2 == 0) evenList else evenList:+head
        innerSplit(rest, newOddList, newEvenList)
      }
    }
    innerSplit(originalElements, List(), List())
  }

  def splitImperative(originalElements: List[Any]): (List[Any], List[Any]) = {
    var oddList: List[Any] = List();
    var evenList: List[Any] = List();

    for (i <- 0 until originalElements.length) {
      if(i % 2 == 0) {
        oddList = oddList:+originalElements(i)
      } else {
        evenList = evenList:+originalElements(i)
      }
    }

    (oddList, evenList)
  }

  println(splitFunctional(List(1,2, 3, 4, 5, 6, 7, 8, 9, 10)))
  println(splitFunctional(List(5, 6, 3, 2, 1)))

  println(splitImperative(List(1,2, 3, 4, 5, 6, 7, 8, 9, 10)))
  println(splitImperative(List(5, 6, 3, 2, 1)))
}