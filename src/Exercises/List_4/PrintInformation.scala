package Exercises.List_4

sealed trait Result
case class Error(message: String) extends Result

object PrintInformation extends App {
  def getInformation(arg: Any): String = arg match {
    case s: String => "String"
    case i: Int => "Integer"
    case l: List[_] => "Some list"
    case d: Double => "Double"
    case Error(message) => "Error"
  }

  println(getInformation("Test"))
  println(getInformation(5))
  println(getInformation(List(1, 2, 3)))
  println(getInformation(1.0))
  println(getInformation(Error("An error has occurred.")))

  assert(getInformation("Test") == "String")
  assert(getInformation(5) == "Integer")
  assert(getInformation(List(1, 2, 3)) == "Some list")
  assert(getInformation(1.0) == "Double")
  assert(getInformation(Error("An error has occurred.")) == "Error")
}