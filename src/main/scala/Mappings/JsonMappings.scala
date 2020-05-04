package Mappings

import Models.{Car, Error}
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

trait JsonMappings extends SprayJsonSupport with DefaultJsonProtocol {

  implicit val carFormat = jsonFormat5(Car)
  implicit val errorFormat = jsonFormat2(Error)

}