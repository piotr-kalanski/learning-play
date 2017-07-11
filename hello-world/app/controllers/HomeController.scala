package controllers

import javax.inject._

import models.Person
import org.json4s.DefaultFormats
import play.api._
import play.api.libs.json.Json
import play.api.mvc._
import org.json4s.native.Serialization.write

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  implicit val formats = DefaultFormats
  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def getName() = Action {
    Ok("Piotrek K")
  }

  def getPerson(id: String) = Action {
    Ok(write(Person(id, "p_" + id)))
  }

  def getPeople() = Action {
    Ok(write(Seq(
      Person("1", "p1"),
      Person("2", "p2"),
      Person("3", "p3")
    )))
  }
}
