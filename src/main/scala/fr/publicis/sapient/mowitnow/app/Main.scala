package fr.publicis.sapient.mowitnow.app

import fr.publicis.sapient.mowitnow.app.core.Runner
import fr.publicis.sapient.mowitnow.app.io.FileReader
import fr.publicis.sapient.mowitnow.app.parser.FileParser.{parseInstructions, parsePosition}

object Main extends FileReader {

  def main(args: Array[String]): Unit = {
    val argsLength: Int = args.length
    if (argsLength == 1) {
      val runner: Runner = new Runner
      val relPath = readFile(args(0))
      val fileContent: List[String] = readTextFile(relPath).get
      val lawnSurface: String = fileContent(0)
      println(lawnSurface)
      val elts: List[(String, String)] = for (List(first, second) <- fileContent.drop(1).grouped(2).toList) yield (first, second)
      println(elts)
      for (elt ← elts) {
        val positionRaw: List[String] = elt._1.split(" ").toList
        val instructionRaw: List[Char] = elt._2.toList
        runner.executeInstructions(
          parsePosition(positionRaw),
          parseInstructions(instructionRaw)
        )
      }
    } else {
      throw new IllegalArgumentException("Need the file path/name")
    }
  }

}
