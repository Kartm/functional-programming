package Laboratories.Class_6

sealed trait Tree[+T]

case object Leaf extends Tree[Nothing]

case class Branch[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]

object FindInTree_1 extends App {
  def find(phrase: String, tree: Tree[String]): List[String] = tree match {
    case Branch(value, left, right) => {
      val result = if(value.contains(phrase)) List(value) else List()

      result ::: find(phrase, left) ::: find(phrase, right)
    }
    case Leaf => List()
  }

  val tree = Branch("Test",Branch("Testtt", Leaf, Leaf), Branch("estt", Leaf, Branch("SuperTes", Leaf, Leaf)))
  println(find("Tes", tree))

  val tree2 = Branch("ABC",Leaf, Leaf)
  println(find("A", tree2))

  println(find("somelongstring", tree2))
}