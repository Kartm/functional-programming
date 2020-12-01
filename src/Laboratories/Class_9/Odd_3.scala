package Laboratories.Class_9

object Odd_3 extends App {
  def oddFunctional(k: Int, n: Int): List[Int] = {
    val startingPoint = if(k % 2 == 0) k + 1 else k
    val endingPoint = startingPoint + 2 * n
    Seq.range(startingPoint, endingPoint, 2).toList
  }

  def oddImperative(k: Int, n: Int): List[Int] = {
    var resultList: List[Int] = List()

    var startingPoint = k;
    if(startingPoint % 2 == 0) {
      startingPoint += 1;
    }

    for(i <- 0 until n) {
      resultList = resultList :+ (startingPoint + 2*i)
    }

    resultList
  }

  println(oddFunctional(12, 2))
  println(oddImperative(12, 2))

  println(oddFunctional(0, 0))
  println(oddImperative(0, 0))

  println(oddFunctional(-10, 10))
  println(oddImperative(-10, 10))
}