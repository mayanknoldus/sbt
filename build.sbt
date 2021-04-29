name := "common"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies += "org.json4s" %% "json4s-native" % "3.7.0-M16"

libraryDependencies += "org.slf4j" % "slf4j-api" % "2.0.0-alpha1"

libraryDependencies += "com.typesafe" % "config" % "1.4.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test

libraryDependencies += "org.mockito" %% "mockito-scala" % "1.16.37" % Test

lazy val persistence = project.in(file("persistence"))

  .settings {
    libraryDependencies += "com.github.tminglei" %% "slick-pg" % "0.19.6"

    libraryDependencies += "org.postgresql" % "postgresql" % "42.2.20"

    libraryDependencies += "org.eclipse.dirigible" % "dirigible-database-h2" % "5.10.0"

  }

lazy val common = project.dependsOn(persistence)

lazy val root = project.in(file(".")).aggregate(persistence)
