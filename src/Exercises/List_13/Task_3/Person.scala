package Exercises.List_13.Task_3

// Create a class Person with fields firstName and lastName using Ordered
// trait add needed methods which allow to sort list of Persons by lastName (if same
// then firstName define the order).
case class Person(firstName: String, lastName: String, age: Int) extends Ordered[Person] {
  def compare(that: Person) =
    if (this.lastName == that.lastName)
      this.firstName compare that.firstName
    else this.lastName compare that.lastName
}

object Main extends App {
  val people = List(Person("Anna", "Ankowska", 20), Person("Adam", "Mądrzejak", 40), Person("Bartosz", "Dachowski", 25))

  println(people.sorted)
}