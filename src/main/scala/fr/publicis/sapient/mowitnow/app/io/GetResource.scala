package fr.publicis.sapient.mowitnow.app.io

/**
 * Resource accessor: facilitator.
 */
trait GetResource {

  private[mowitnow] val FileSeparator: String = "/"

  /**
   * Gets full path from file name.
   *
   * @param file File name.
   * @return File's full path.
   */
  def getResource(file: String): String = {
    if (file.startsWith(FileSeparator)) {
      this.getClass.getResource(file).getPath
    }
    else {
      this.getClass.getResource(FileSeparator + file).getPath
    }
  }
}
