
import DAO.CarDAO
import Mappings.JsonMappings
import Models.Car
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import ch.megard.akka.http.cors.scaladsl.CorsDirectives._
import spray.json._

trait Routes extends JsonMappings with ApiErrorHandler {

  def routes():Route = {
      cors(){
        pathPrefix("car"){

          (path("all") & get){
            complete(CarDAO.all().toJson)
          } ~
          (path("add") & post){
            entity(as[Car]) { c =>
              complete(CarDAO.add(c).toJson)
            }
          } ~
          (path("update"/IntNumber) & put){ id =>
            entity(as[Car]) { c =>
              complete(CarDAO.update(id.toLong, c))
            }
          } ~
          (path("make"/"""\w+""".r) & get){ make =>
              complete(CarDAO.getByMake(make).toJson)
          } ~
          (path("year"/"""[1-2]\d\d\d""".r) & get){ year =>
            complete(CarDAO.getByYear(year).toJson)
          } ~
          (path("manufacturer"/"""\w+""".r) & get){ manu =>
            complete(CarDAO.getByManufacturer(manu).toJson)
          } ~
          (path("model"/"""\w+""".r) & get){ model =>
            complete(CarDAO.getByModel(model).toJson)
          } ~
          (path("delete"/IntNumber) & delete){ id =>
            CarDAO.delete(id)
            complete(CarDAO.all().toJson)
          } ~
          (path(IntNumber) & get) { id =>
            complete(CarDAO.getById(id).toJson)
          }

        }

      }
  }

}
