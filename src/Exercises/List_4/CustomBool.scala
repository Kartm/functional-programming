package Exercises.List_4

sealed trait Bool
case object True extends Bool
case object False extends Bool

object CustomBool extends App {
  def and(a: Bool, b: Bool): Bool = (a, b) match {
    case(True, True) => True
    case _ => False
  }

  def or(a: Bool, b: Bool): Bool = (a, b) match {
    case(False, False) => False
    case _ => True
  }

  def xor(a: Bool, b: Bool): Bool = (a, b) match {
    case(True, True) => False
    case(False, False) => False
    case _ => True
  }

  def nand(a: Bool, b: Bool): Bool = (a, b) match {
    case(True, True) => False
    case _ => True
  }

  def nor(a: Bool, b: Bool): Bool = (a, b) match {
    case(False, False) => True
    case _ => False
  }

  println(and(True, True))
  assert(and(True, True) == True)
  assert(and(True, False) == False)
  assert(and(False, True) == False)
  assert(and(False, False) == False)

  assert(or(True, True) == True)
  assert(or(True, False) == True)
  assert(or(False, True) == True)
  assert(or(False, False) == False)

  assert(xor(True, True) == False)
  assert(xor(True, False) == True)
  assert(xor(False, True) == True)
  assert(xor(False, False) == False)

  assert(nand(True, True) == False)
  assert(nand(True, False) == True)
  assert(nand(False, True) == True)
  assert(nand(False, False) == True)

  assert(nor(True, True) == False)
  assert(nor(True, False) == False)
  assert(nor(False, True) == False)
  assert(nor(False, False) == True)
}