package fr.publicis.sapient.mowitnow.app

import fr.publicis.sapient.mowitnow.app.core.Runner
import fr.publicis.sapient.mowitnow.app.io.FileReader
import fr.publicis.sapient.mowitnow.app.model.Position
import fr.publicis.sapient.mowitnow.app.parser.FileParser.{parseInstructions, parsePosition}

import scala.collection.mutable

object Main extends FileReader {

  /**
   * Entry_point
   *
   * @param args arguments from outside
   */
  def main(args: Array[String]): Unit = {
    if (args.length == 1) {
      //val path: String = args(0)
      val path: String = "files/input"
      val relPath: String = readFile(path)
      val fileContent: List[String] = readTextFile(relPath).get
      val serializedObject: (String, List[(String, String)]) = extractObjectFromRawFile(fileContent)
      run(serializedObject._2)
    } else {
      throw new IllegalArgumentException("Need the file path/name")
    }
  }

  /**
   * Extract data from raw file
   *
   * @param fileContent text to List[String]
   * @return
   */
  def extractObjectFromRawFile(fileContent: List[String]): (String, List[(String, String)]) = {
    val lawnSurface: String = fileContent(0)
    val positionAndInstruction: List[(String, String)] = for (List(first, second) <- fileContent.drop(1).grouped(2).toList) yield (first, second)
    (lawnSurface, positionAndInstruction)
  }

  /**
   * Run all the instructions
   *
   * @param positionAndInstruction Position(1,0,N) and Instruction(A,G,D)
   * @return
   */
  def run(positionAndInstruction: List[(String, String)]): List[Position] = {
    val runner: Runner = new Runner
    val outputPositionList: mutable.MutableList[Position] = mutable.MutableList[Position]()

    for (elt ← positionAndInstruction) {
      val positionRaw: List[String] = elt._1.split(" ").toList
      val instructionRaw: List[Char] = elt._2.toList
      val lastPosition: Position = runner.executeInstructions(
        parsePosition(positionRaw),
        parseInstructions(instructionRaw)
      )
      outputPositionList += lastPosition
    }
    outputPositionList.toList
  }

}
