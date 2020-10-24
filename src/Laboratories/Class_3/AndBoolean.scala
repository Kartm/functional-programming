package Laboratories.Class_3

object AndBoolean extends App {
  def and(a: Boolean, b: Boolean): Boolean = a match {
    case true => b match {
      case true => true // the only case when and(a,b) yields true
      case _ => false
    }
    case _ => false
  }

  println(and(true, false))

  assert(and(true, true) == true)
  assert(and(true, false) == false)
  assert(and(false, true) == false)
  assert(and(false, false) == false)
}