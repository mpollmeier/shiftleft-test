name := "shiftleft etst"

scalaVersion := "2.12.6"
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.3" % Test
)

scalacOptions ++= Seq("-deprecation", "-feature")
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

lazy val docs = project
  .in(file("docs"))
  .enablePlugins(MicrositesPlugin)
  .settings(
    micrositeGitterChannel := false,
    micrositeShareOnSocial := false,
    micrositeGithubLinks := false,
    micrositeHighlightTheme := "monokai",
    micrositeHighlightTheme   := "color-brewer",
    // micrositePalette := Map(
    //   "brand-primary"     -> "#E35D31",
    //   "brand-secondary"   -> "#B24916",
    //   "brand-tertiary"    -> "#B24916",
    //   "gray-dark"         -> "#453E46",
    //   "gray"              -> "#837F84",
    //   "gray-light"        -> "#E3E2E3",
    //   "gray-lighter"      -> "#F4F3F4",
    //   "white-color"       -> "#FFFFFF"
    // ),
  )
