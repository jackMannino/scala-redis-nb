import sbt._
import Keys._

object ScalaRedisProject extends Build {

  import Resolvers._

  lazy val root = Project("RedisReact", file(".")) settings (coreSettings: _*)

  lazy val commonSettings: Seq[Setting[_]] = Seq(
    organization := "net.debasishg",
    version := "0.9",
    scalaVersion := "2.12.1",
    scalacOptions := Seq("-deprecation", "-unchecked", "-feature", "-language:postfixOps"),
    resolvers ++= Seq(akkaRelease, akkaSnapshot, sprayJson)
  )

  val akkaVersion = "2.5"

  val json4sVersion = "3.5.0"

  lazy val coreSettings = commonSettings ++ Seq(
    name := "RedisReact",
    libraryDependencies :=
      Seq(
        "com.typesafe.akka" % "akka-actor_2.12" % "2.5.0",
        "com.typesafe.akka" %% "akka-slf4j" % "2.5.0" % "provided",
        "commons-pool" % "commons-pool" % "1.6",
        "org.slf4j" % "slf4j-api" % "1.7.7" % "provided",
        "ch.qos.logback" % "logback-classic" % "1.1.2" % "provided",
        "junit" % "junit" % "4.11" % "test",
        "org.scalatest" %% "scalatest" % "3.0.0" % "test",
        "com.typesafe.akka" %% "akka-testkit" % "2.5.0" % "test",

        // Third-party serialization libraries
        //"net.liftweb" %%  "lift-json"      % "2.5.1" % "provided, test",
        "org.json4s" %% "json4s-native" % json4sVersion % "provided, test",
        "org.json4s" %% "json4s-jackson" % json4sVersion % "provided, test",
        "io.spray" %% "spray-json" % "1.3.2" % "provided, test"
      )
  )
}

object Resolvers {
  val akkaRelease = "typesafe release repo" at "http://repo.typesafe.com/typesafe/releases/"
  val akkaSnapshot = "typesafe snapshot repo" at "http://repo.typesafe.com/typesafe/snapshots/"
  val sprayJson = "spray" at "http://repo.spray.io/"
}
