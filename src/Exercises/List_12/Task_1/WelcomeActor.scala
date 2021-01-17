package Exercises.List_12.Task_1

import akka.actor.{Actor, ActorSystem, Props}
// Write actor which welcome 3 known users, represented by message with name in specific way, for example
// msg(“Anna”) -> “Hi Anna”,
// msg(“Tom”) -> “Hello Tom”),
// and show some generic message for unknown name.

class WelcomeActor extends Actor {

  def receive = {
    case "Anna" => println("Hello Anna!")
    case "Tom" => println("Welcome Tom!")
    case "Jack" => println("How are you Jack?")
    case _ => println("Unknown name.")
  }
}

object Main extends App {
  val system = ActorSystem("WelcomeSystem")

  val welcomeActor = system.actorOf(Props[WelcomeActor], name="WelcomeActor")

  welcomeActor ! "Anna"
  welcomeActor ! "Tom"
  welcomeActor ! "Jack"
  welcomeActor ! "Caroline"

  Thread.sleep(1000);

  system.terminate();
}
