package Exercises.List_13.Task_1

object Main extends App {
  object Duck {
    def makeNoise() = {
      "quack"
    }
  }

  object Cat {
    def makeNoise() = {
      "meow"
    }
  }

  def noiser(animal: {def makeNoise(): String}): Unit = {
    println(animal.makeNoise())
  }

  noiser(Duck)
  noiser(Cat)
}
