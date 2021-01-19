package Exercises.List_13.Task_4

import scala.collection.mutable.Map;
// Define the method wordCounter
// that counts occurring words in a given text. Please assume that the words are
// separated by spaces. The result needs to be a modifiable dictionary (Map), in
// which words are keys and number instances of words are values.
object Main extends App {
  def wordCounter(text: String): Map[String, Int] = {
    val result: Map[String, Int] = Map().withDefaultValue(0)
    text.split(' ').foreach(word => result(word) += 1)
    result
  }

  println(wordCounter("Test test test some example values here test"))
}
