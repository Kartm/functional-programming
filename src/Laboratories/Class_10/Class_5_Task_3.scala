package Laboratories.Class_10

/*
Write a function that returns a "mirror image" of the tree defined in lecture 3.


    Points: 6 (Scala language).
 */

sealed trait Tree[+T]

case object Leaf extends Tree[Nothing]

case class Branch[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]

object MirrorTree_3 extends App {
  def mirror[T](tree: Tree[T]): Tree[T] = tree match {
    case Leaf => Leaf
    case Branch(value, left, right) => Branch(value, mirror(right), mirror(left))
  }

  val tree = Branch(1, Branch(2, Leaf, Leaf), Branch(3, Branch(4, Branch(5, Leaf, Leaf), Leaf), Leaf))
  println(tree)
  println(mirror(tree))
}