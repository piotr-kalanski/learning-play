package controllers

import javax.inject._

import models.Person
import play.api.libs.json.Json
import play.api.mvc._

import scala.collection.mutable

@Singleton
class PeopleController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  implicit val personWrites = Json.writes[Person]
  implicit val personReads = Json.reads[Person]

  private val people = new mutable.ListBuffer[Person]

  people ++= Seq(
    Person("1", "p1"),
    Person("2", "p2"),
    Person("3", "p3")
  )

  def getPerson(id: String) = Action {
    val result = people.find(_.id == id)
    if(result.nonEmpty)
      Ok(Json.toJson(result.get))
    else
      NotFound
  }

  def getPeople = Action {
    Ok(Json.toJson(people))
  }

  def addPerson = Action { request =>
    val json = request.body.asJson.get
    val person = json.as[Person]
    people += person
    Ok
  }

}
