package Laboratories.Class_9

import scala.math.max;

object Merge_2 extends App {
  def mergeFunctional(leftList: List[Any], rightList: List[Any]): List[Any] = {
    leftList.zipAll(rightList, null, null).flatten { case (a, b) => List(a, b) }.filter(x => x != null)
  }

  def mergeImperative(leftList: List[Any], rightList: List[Any]): List[Any] = {
    var resultList: List[Any] = List()

    for (i <- 0 until max(leftList.length, rightList.length)) {
      if (i < leftList.length) {
        resultList = resultList :+ leftList(i)
      }

      if (i < rightList.length) {
        resultList = resultList :+ rightList(i)
      }

    }

    resultList
  }

  println(mergeFunctional(List(1, 3, 5, 7, 9, 11), List(2, 4, 6, 8)))
  println(mergeImperative(List(1, 3, 5, 7, 9, 11), List(2, 4, 6, 8)))
}