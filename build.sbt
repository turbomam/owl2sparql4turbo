name := "hello"
  
version := "1.0"
  
scalaVersion := "2.10.2"

// resolvers += "University Leipzig, AKSW Maven2 Repository" at "http://maven.aksw.org/repository/internal/"

resolvers += "University Leipzig, AKSW Maven2 Repository" at "http://maven.aksw.org/repository/snapshots/"

libraryDependencies += "org.aksw.owl2sparql" % "owl2sparql-core" % "0.1-SNAPSHOT"


