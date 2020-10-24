package Exercises.List_1_2

object Main extends App {
  object MyObject{
    // return type is integer
    // returns 12
    val add=(x:Int,y:Int,z:Int)=>x+y+z
    println(add(2,3,7))

    // return type is implicitly integer
    // returns 13
    def method()={
      val x=2*5
      x+3}
  }
  println(MyObject.method())
}