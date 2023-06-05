package fr.publicis.sapient.mowitnow.app.model

object Coordinates {

  /**
   *
   * @param coordinates
   * @return
   */
  def checkCoordinatesBoundaries(coordinates: Coordinates): Boolean = {
    (
      (coordinates.x >= XMinLawnSize)
        &&
        (coordinates.y >= YMinLawnSize)
        &&
        (coordinates.x <= XMaxLawnSize)
        &&
        (coordinates.y <= YMaxLawnSize)
      )
  }


}

/**
 * Coordinates object model
 *
 * @param x x position
 * @param y y Position
 */
case class Coordinates(
                        x: Int,
                        y: Int
                      )
