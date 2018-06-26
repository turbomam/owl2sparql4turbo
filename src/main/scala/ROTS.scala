import java.io.File
import scala.compat.java8.StreamConverters.RichStream
import org.aksw.owl2sparql.OWLClassExpressionToSPARQLSubClassQueryConverter
import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.model.IRI
import org.semanticweb.owlapi.search.EntitySearcher

object ROTS {
  
  // SPARQL searches for Rosuvastatin Oral Tablet classes
  
  def main(args: Array[String]): Unit = {

    var manager = OWLManager.createOWLOntologyManager()
    var ontology = manager.loadOntologyFromOntologyDocument(new File("rots.owl"))

    // use a factory to convert stings to IRI objects
    var factory = manager.getOWLDataFactory()
    var termIRI = IRI.create("http://purl.obolibrary.org/obo/DRON_00081385")
    var someClass = factory.getOWLClass(termIRI)

    var classSupers = EntitySearcher.getSuperClasses(someClass, ontology).toScala[Stream]

    var oneSuper = classSupers(0)

    var scConverter = new OWLClassExpressionToSPARQLSubClassQueryConverter()
    var targetVar = "?x"

    var queryStr = scConverter.convert(oneSuper, targetVar)

    println(queryStr)

  }
}