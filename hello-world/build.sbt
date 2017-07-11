name := """hello-world"""
organization := "com.datawizards"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  guice,
  "org.json4s" % "json4s-native_2.12" % "3.5.2",
  "org.json4s" % "json4s-jackson_2.12" % "3.5.2",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.datawizards.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.datawizards.binders._"
