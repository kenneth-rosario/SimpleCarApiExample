import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import util.LoggingConfig

import akka.http.scaladsl.server.Directives._

import scala.concurrent.ExecutionContext
import scala.io.StdIn.readLine

object Main extends App with LoggingConfig with Routes {

  implicit val system:ActorSystem = ActorSystem("FlovverApi")
  implicit val executor: ExecutionContext = system.dispatcher
  implicit val log: LoggingAdapter = Logging(system, getClass)

  Http().bindAndHandle(handler = logRequestResult(requestMethodAndResponseStatusAsInfo _ )(routes()), port=5000, interface="127.0.0.1")
  println("Server Online at localhost:5000")
  readLine("Press any key to quit ...\n")
  system.terminate()

}
