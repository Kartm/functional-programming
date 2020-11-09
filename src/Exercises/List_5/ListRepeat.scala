package Exercises.List_5

object ListRepeat extends App {
  def lrepeat[A](k: Int)(list: LazyList[A]): LazyList[A] = {
    if(k < 1) {
      return LazyList()
    } else if (k == 1) {
      return list
    } else {
      return list #::: lrepeat(k-1)(list)
    }
  }

  val someList : LazyList[Int] = LazyList(1, 2, 3)

  val a = lrepeat(2)(someList)
  println(a(0))
  println(a(1))
  println(a(2))
  println(a(3))
  println(a(4))
  println(a(5))
  //println(a(6)) // throws exception since out of bounds
}