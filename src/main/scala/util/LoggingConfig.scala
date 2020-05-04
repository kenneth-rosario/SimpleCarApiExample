package util

import akka.event.Logging
import akka.http.scaladsl.model.HttpRequest
import akka.http.scaladsl.server.RouteResult
import akka.http.scaladsl.server.RouteResult.{Complete, Rejected}
import akka.http.scaladsl.server.directives.LogEntry

trait LoggingConfig {
  def requestMethodAndResponseStatusAsInfo(req: HttpRequest): RouteResult => Option[LogEntry] = {
    case Complete(res) => Some(LogEntry(req.method.name + " to " + req.uri + " : " + res.status, Logging.InfoLevel))
    case Rejected(res) => Some(LogEntry(req.method.name + " to " + req.uri + " : REJECTED " +  Logging.InfoLevel)) // no log entries for rejections
  }
}
