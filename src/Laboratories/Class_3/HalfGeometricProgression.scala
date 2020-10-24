package Laboratories.Class_3

object HalfGeometricProgression extends App {
  def half_geometric(firstElement: Double, ratio: Double, numberOfElements: Int): List[Double] =  {
    def loop(accum: List[Double], currentNumber: Double, i: Int): List[Double] = {
      if (i == numberOfElements) {
        return accum
      }
      else {
        var newList = accum :+ (currentNumber / 2)
        return loop(newList, currentNumber * ratio, i + 1)
      }
    }

    loop(List(), firstElement, 0)
  }

  println(half_geometric (1,2,4))

  assert(half_geometric (1,2,4) == List(0.5, 1, 2, 4))
  assert(half_geometric (3,5,5) == List(1.5, 7.5, 37.5, 187.5, 937.5))
  assert(half_geometric (1,1,1) == List(0.5))
}