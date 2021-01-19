package Exercises.List_13.Task_2

object Main extends App {
  class Foo {
    def method(input: String) = input
  }

  class Bar {
    def method(input: String) = input
  }

  //val brokenFoo: Foo = new Bar(); // <- error

  val foo: {def method(input: String): String} = new Foo();
  val bar: {def method(input: String): String} = new Bar();
}
