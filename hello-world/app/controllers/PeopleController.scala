package controllers

import javax.inject._

import models.Person
import play.api.libs.json.Json
import play.api.mvc._

@Singleton
class PeopleController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  implicit val personWrites = Json.writes[Person]

  def getPerson(id: String) = Action {
    Ok(Json.toJson(Person(id, "p_" + id)))
  }

  def getPeople = Action {
    Ok(Json.toJson(Seq(
      Person("1", "p1"),
      Person("2", "p2"),
      Person("3", "p3")
    )))
  }

}
