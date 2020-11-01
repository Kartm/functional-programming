package Exercises.List_4

sealed trait Calculation
final case class Literal(v: Double) extends Calculation
final case class Add(a: Calculation, b: Calculation) extends Calculation
final case class Negate(a: Calculation) extends Calculation

object Calculator extends App {
  def eval(expr: Calculation): Double = expr match {
    case Literal(v) => v
    case Add(a, b) => eval(a) + eval(b)
    case Negate(a) => eval(a) * (-1)
  }

  println(eval(Add(Literal(1), Literal(2))))
  println(eval(Negate(Literal(42))))

  assert(eval(Add(Negate(Literal(42)), Literal(2))) == -40.0)
  assert(eval(Add(Literal(1), Literal(2))) == 3.0)
  assert(eval(Negate(Literal(42))) == -42.0)
}