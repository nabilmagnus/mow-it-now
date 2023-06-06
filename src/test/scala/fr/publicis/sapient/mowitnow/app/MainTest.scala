package fr.publicis.sapient.mowitnow.app

import fr.publicis.sapient.mowitnow.app.Main.{extractObjectFromRawFile, readFile, readTextFile}
import fr.publicis.sapient.mowitnow.app.io.GetResource
import fr.publicis.sapient.mowitnow.app.model.Position
import fr.publicis.sapient.mowitnow.app.parser.FileParser.parsePosition
import org.junit.runner.RunWith
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.junit.JUnitRunner

import scala.collection.mutable

/**
 * =MainTest=
 */
@RunWith(classOf[JUnitRunner])
class MainTest
  extends AnyWordSpec
    with Matchers
    with GetResource {

  "Integration test" should {
    "return exactly output" in {
      val expectedPositionList: mutable.MutableList[Position] = mutable.MutableList[Position]()
      val inputPath: String = "files/input"
      val inputRelPath: String = readFile(inputPath)
      val outputPath: String = "files/output"
      val outputRelPath: String = readFile(outputPath)

      val inputFileContent: List[String] = readTextFile(inputRelPath).get
      val serializedObject: (String, List[(String, String)]) = extractObjectFromRawFile(inputFileContent)
      val transformedPositionList: List[Position] = Main.run(serializedObject._2)

      val outputFileContent: List[String] = readTextFile(outputRelPath)
        .get
      for (elt ← outputFileContent) {
        val newPosition: Position = parsePosition(
          elt.split(" ").toList
        )
        expectedPositionList += newPosition
      }
      println(expectedPositionList)
      println(transformedPositionList.toList)
      assert(expectedPositionList == transformedPositionList)
    }
  }

}
