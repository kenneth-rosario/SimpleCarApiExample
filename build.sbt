name := "carapi"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= {

  val akkaVersion = "2.6.4"
  val akkaHttpVersion = "10.1.10"

  Seq(
      "com.typesafe.akka" %% "akka-actor"% akkaVersion,
      "com.typesafe.akka" %% "akka-actor"% akkaVersion,
      "com.typesafe.akka" %% "akka-http"   % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream" % akkaVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "io.spray" %% "spray-json" % "1.3.5",
      "ch.megard" %% "akka-http-cors" % "0.4.2",
  )

}
