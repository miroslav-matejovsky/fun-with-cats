ThisBuild / scalaVersion := "2.13.0"
ThisBuild / name := "fun-with-cats"
ThisBuild / version := "0.1"
ThisBuild / organization := "sk.bsmk"

ThisBuild / scalafmtOnCompile := true

lazy val `fun-with-cats` = (project in file("."))
  .settings(
    commonSettings,
    name := "fun-with-cats",
    libraryDependencies ++= Seq(
      compilerPlugin("com.softwaremill.neme" %% "neme-plugin" % "0.0.3"),
      "org.typelevel" %% "cats-effect" % "2.0.0"
    )
  )

lazy val commonSettings = smlBuildSettings ++ Seq(
  // your settings, which can override some of smlBuildSettings
)

lazy val smlBuildSettings =
  commonSmlBuildSettings    ++ // compiler flags
    splainSettings            ++ // gives rich output on implicit resolution errors
    dependencyUpdatesSettings ++ // check dependency updates on startup (max once per 12h)
    wartRemoverSettings       ++ // warts
    acyclicSettings           ++ // check circular dependencies between packages
    ossPublishSettings           // configures common publishing process for all OSS libraries