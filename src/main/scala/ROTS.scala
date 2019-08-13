import java.io.File
import scala.compat.java8.StreamConverters.RichStream
import org.aksw.owl2sparql.OWLClassExpressionToSPARQLSubClassQueryConverter
import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.model.IRI
import org.semanticweb.owlapi.search.EntitySearcher

object ROTS {

  // Original case: SPARQL searches for Rosuvastatin Oral Tablet classes
  // for HTN elevated blood pressure, need to change proposed subclass query with query for equivalent class assertion
  // https://stackoverflow.com/questions/7250189/how-to-build-sparql-queries-in-java
  // https://rdf4j.eclipse.org/documentation/sparqlbuilder/

  def main(args: Array[String]): Unit = {

    var manager = OWLManager.createOWLOntologyManager()
    //    var ontology = manager.loadOntologyFromOntologyDocument(new File("rots.owl"))
    var ontology = manager.loadOntologyFromOntologyDocument(new File("htn.ttl"))

    // use a factory to convert stings to IRI objects
    var factory = manager.getOWLDataFactory()
    //    var termIRI = IRI.create("http://purl.obolibrary.org/obo/DRON_00081385")
    //    var termIRI = IRI.create("http://purl.obolibrary.org/obo/DRON_00059149")
    var termIRI = IRI.create("http://purl.obolibrary.org/obo/HTN_00000048")

    var someClass = factory.getOWLClass(termIRI)

    //    var classSupers = EntitySearcher.getSuperClasses(someClass, ontology).toScala[Stream]
    var classSupers = EntitySearcher.getEquivalentClasses(someClass, ontology).toScala[Stream]
    for (oneSuper <- classSupers) {
      println(oneSuper)
      println("\n")

      var scConverter = new OWLClassExpressionToSPARQLSubClassQueryConverter()
      //      var scConverter = new org.aksw.owl2sparql.OWLClassExpressionToSPARQLConverter()

      var targetVar = "?x"

      var queryStr = scConverter.convert(oneSuper, targetVar)
      //      var queryStr = scConverter.convert(oneSuper, targetVar, false)
      //
      println(queryStr)
      println("\n")
      println("\n")

    }

  }
}
