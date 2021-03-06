val dottyVersion = "0.21.0-RC1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-features-sample",
    version := "0.1.0",

    scalaVersion := dottyVersion,
    scalacOptions += "-strict",

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )
