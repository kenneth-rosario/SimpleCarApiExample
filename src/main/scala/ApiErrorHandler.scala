import Mappings.JsonMappings
import Models.Error
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.ExceptionHandler

import spray.json._

trait ApiErrorHandler extends JsonMappings {
  implicit def myExceptionHandler: ExceptionHandler = ExceptionHandler {
    case e: java.util.NoSuchElementException =>
      extractUri { uri =>
        val error = Error(status = "404", message = "No element found")
        complete(StatusCodes.NotFound ->  error.toJson)
      }
  }
}