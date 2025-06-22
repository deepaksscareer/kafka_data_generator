ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.14"

lazy val root = (project in file("."))
  .settings(
    name := "stream_data_generator"
  )

libraryDependencies ++= Seq(
  // Kafka Client
  "org.apache.kafka" % "kafka-clients" % "3.7.0",

  // Logging (required by Kafka client)
  "ch.qos.logback" % "logback-classic" % "1.4.14",

  // JSON (optional, for serializing messages)
  "io.circe" %% "circe-core" % "0.14.6",
  "io.circe" %% "circe-generic" % "0.14.6",
  "io.circe" %% "circe-parser" % "0.14.6",

  // Typesafe Config for reading config files (optional)
  "com.typesafe" % "config" % "1.4.3"
)