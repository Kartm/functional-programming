package Exercises.List_12.Task_3

import akka.actor.{Actor, ActorSystem, Props}

import scala.util.Random

case class Ball(count: Int)

class BallPlayerActor extends Actor {
  val random = new Random

  def randomElementExcept[T](array: Array[T], element: T) = {
    if(array.length == 0 && array(0) == element) {
      throw new Exception("Array has not enough elements.")
    }

    var randomElement = array(random.nextInt(array.length))
    while(randomElement == element) {
      randomElement = array(random.nextInt(array.length))
    }

    randomElement
  }

  def randomActor(currentActorId: String) = {
    val ids = Array("1", "2", "3")

    context.actorSelection(String.format("../%s", randomElementExcept(ids, currentActorId)))
  }

  def receive = {
    case Ball(count) => {
      Thread.sleep((Math.random * 800).toLong + 200)

      val otherActor = randomActor(self.path.name)
      printf("%s -> %s, #%d\n", self.path.name, otherActor.pathString.split('/').last, count)

      otherActor.tell(Ball(count + 1), self)
    }
    case _ => println("Unknown message.")
  }
}

object Main extends App {
  val system = ActorSystem("BallGameSystem")

  val actors = (1 to 3).map(i => system.actorOf(Props[BallPlayerActor], name=i.toString())).toArray

  actors(0) ! Ball(0)
}