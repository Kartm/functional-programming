package Exercises.List_12.Task_2

import akka.actor.{Actor, ActorSystem, Props}

import java.util.concurrent.TimeUnit
import scala.concurrent.Await
import scala.concurrent.duration.Duration

case class Ball(isPlayerA: Boolean, aScore: Int, bScore: Int)
case object Win

class PlayerActor extends Actor {
  val WIN_SCORE = 10;

  def receive = {
    case Ball(isPlayerA, aScore, bScore) => {
      printf("%d : %d\n", aScore, bScore)

      sender ! (if(Array(aScore, bScore) contains WIN_SCORE) Win else move(isPlayerA, aScore, bScore))
    }
    case Win => printf("%s won.", self.path.name);
    case _ => println("Unknown message.")
  }

  def move(isPlayerA: Boolean, aScore: Int, bScore: Int): Ball = {
    Thread.sleep((Math.random * 400).toLong + 100)

    val isHit = math.random() > 0.5;

    val newAScore = (isPlayerA, aScore, isHit) match {
      case (true, score, true) => score + 1
      case(false, score, false) => score + 1
      case _ => aScore
    }

    val newBScore = (isPlayerA, bScore, isHit) match {
      case (false, score, true) => score + 1
      case(true, score, false) => score + 1
      case _ => bScore
    }

    Ball(!isPlayerA, newAScore, newBScore)
  }
}

object Main extends App {
  val system = ActorSystem("PingPongGame")

  val playerA = system.actorOf(Props[PlayerActor], name="Player_A")
  val playerB = system.actorOf(Props[PlayerActor], name="Player_B")

  val playerAStarts = math.random() > 0.5;

  playerA.tell(Ball(playerAStarts, 0, 0), playerB)
}