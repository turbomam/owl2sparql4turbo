name := "hello"
  
version := "1.0"
  
scalaVersion := "2.10.2"

// resolvers += "University Leipzig, AKSW Maven2 Repository" at "http://maven.aksw.org/repository/internal/"

resolvers += "University Leipzig, AKSW Maven2 Repository" at "http://maven.aksw.org/repository/snapshots/"

libraryDependencies += "org.aksw.owl2sparql" % "owl2sparql-core" % "0.2-SNAPSHOT"

libraryDependencies += "org.apache.commons" % "commons-rdf-api" % "0.5.0"

libraryDependencies += "org.scala-lang.modules" % "scala-java8-compat_2.11" % "0.8.0-RC3"
