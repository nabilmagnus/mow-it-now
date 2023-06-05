package fr.publicis.sapient.mowitnow.app.io

import scala.io.Source
import scala.util.Try

trait FileReader extends GetResource {

  def readFile(path: String): String = {
    val fileContent: String = getResource(path)
    fileContent
  }


  def readTextFile(filename: String): Try[List[String]] = {
    Try(Source.fromFile(filename).getLines.toList)
  }
}
