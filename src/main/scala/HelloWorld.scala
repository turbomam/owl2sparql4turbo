import org.aksw.owl2sparql
import org.aksw.owl2sparql._
import org.semanticweb.owlapi.apibinding.OWLManager
import org.semanticweb.owlapi.model.IRI
import org.semanticweb.owlapi.model.OWLDataFactory
import org.semanticweb.owlapi.model.OWLDataFactory._

import java.io.File

// https://github.com/SmartDataAnalytics/OWL2SPARQL

// http://www.ontobee.org/ontology/DRON?iri=http%3A%2F%2Fpurl.obolibrary.org%2Fobo%2FDRON_00027869

//Class: rosuvastatin Oral
//  Tablet
//  Term IRI: http://purl.obolibrary.org/obo/DRON_00027869

//Superclasses & Asserted Axioms
//
//      drug tablet
//      has_proper_part some (scattered
//      molecular aggregate and (is
//      bearer of some 
//      active ingredient) and (has
//      granular part some 
//      rosuvastatin))

object HelloWorld {
  def main(args: Array[String]): Unit = {

    var adj = "cruel"

    var ce2s = new OWLClassExpressionToSPARQLConverter()

    var a2s = new OWLAxiomToSPARQLConverter("?s", "?o")

    // https://github.com/phillord/owl-api/blob/master/contract/src/test/java/org/coode/owlapi/examples/Examples.java
    // http://syllabus.cs.manchester.ac.uk/pgt/2017/COMP62342/introduction-owl-api-msc.pdf
    // http://owlapi.sourceforge.net/owled2011_tutorial.pdf

    var preManager = new OWLManager
    var manager = OWLManager.createOWLOntologyManager()

    var ontology = manager.loadOntologyFromOntologyDocument(new File("animals.owl"))

    var factory = manager.getOWLDataFactory()
    var iri = IRI.create("http://example.com/carnivore")

    var someClass = factory.getOWLClass(iri)

    var declarationAxiom = factory.getOWLDeclarationAxiom(someClass)

    println(declarationAxiom)

    var temp = ontology.getClassesInSignature()

    //    println(ontology)

    //    println(temp)

    // OWLAxiomToSPARQLConverter("?s","?o")

    //    println("Hello " + adj + " world!")

    var classExp = """
PREFIX: : <http://example.org#>
A and ( B or not (r some B))
"""

    var asSparql = a2s.convert(declarationAxiom, "?s", "?o")

  }
}
