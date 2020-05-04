package DAO

import Models.Car

import scala.collection.mutable.ListBuffer

object CarDAO {

  private var cars:ListBuffer[Car] = ListBuffer()
  private var id_counter = 0

  def all():Seq[Car]={
    cars.seq
  }

  def getById(id:Long):Car={
    cars.filter(_.id.get==id).head
  }

  def delete(id:Long):Unit={
    cars = cars.filter(_.id.get != id)
  }

  def getByMake(make:String):Seq[Car]={
    cars.filter(_.make.get==make)
  }

  def getByModel(model:String):Seq[Car] = {
    cars.filter(_.model.get==model).seq
  }

  def getByYear(year:String):Seq[Car] = {
    cars.filter(_.year.get == year).seq
  }

  def getByManufacturer(manufacturer:String):Seq[Car] = {
    cars.filter(_.manufacturer.get == manufacturer).seq
  }

  def update(id:Long, car:Car):Car = {
    val toChange = cars.filter(_.id.get == id).head

    val newVal = Car(
      id=toChange.id,
      make=if (car.make.isDefined)  car.make else toChange.make,
      model=if (car.model.isDefined)  car.model else toChange.model,
      year=if (car.year.isDefined)  car.year else toChange.year,
      manufacturer = if (car.manufacturer.isDefined) car.manufacturer else toChange.manufacturer
    )

    cars = cars.filter(_.id.get != toChange.id.get)
    cars += newVal
    newVal
  }

  def add(car:Car):Car = {

    id_counter += 1

    val n_car = Car(
      id=Some(id_counter),
      manufacturer = car.manufacturer,
      year = car.year,
      model = car.model,
      make = car.make
    )

    cars += n_car

    n_car

  }

}
