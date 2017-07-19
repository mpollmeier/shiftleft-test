name := "shiftleft etst"

scalaVersion := "2.12.2"
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.3" % Test
)

scalacOptions ++= Seq("-deprecation", "-feature")
scalafmtTestOnCompile in ThisBuild := true
scalafmtFailTest in ThisBuild := false
fork in Test := true
updateOptions := updateOptions.value.withLatestSnapshots(false)
updateOptions := updateOptions.value.withCachedResolution(true)

resolvers ++= Seq(
  Resolver.mavenLocal,
  "Artifactory snapshot local" at "https://shiftleft.jfrog.io/shiftleft/libs-snapshot-local",
  "Artifactory release local" at "https://shiftleft.jfrog.io/shiftleft/libs-release-local",
  "Apache public" at "https://repository.apache.org/content/groups/public/",
  "Sonatype OSS" at "https://oss.sonatype.org/content/repositories/public",
  "Bedatadriven for SOOT dependencies" at "https://nexus.bedatadriven.com/content/groups/public"
)

publishLocal := publishM2.value // always publish to local maven cache to avoid having to look in too many places when debugging
publishTo := {
  val jfrog = "https://shiftleft.jfrog.io/shiftleft/"
  if (isSnapshot.value)
    Some("snapshots" at jfrog + "libs-snapshot-local")
  else
    Some("releases"  at jfrog + "libs-release-local")
}
publishMavenStyle := true
