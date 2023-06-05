package fr.publicis.sapient.mowitnow.app.model

import fr.publicis.sapient.mowitnow.app.model.Position.CardinalDirection

object Position {

  /**
   * Sealed trait with four directions possibility
   */
  sealed trait CardinalDirection {
    def name: String
  }

  case object N extends CardinalDirection {
    val name: String = "N"
  } //etc.

  case object S extends CardinalDirection {
    val name: String = "S"
  } //etc.

  case object E extends CardinalDirection {
    val name: String = "E"
  } //etc.

  case object W extends CardinalDirection {
    val name: String = "W"
  } //etc.

  case class UnknownCardinalDirection(name: String) extends CardinalDirection

}


/**
 * Position object model
 *
 * @param Coordinates (x,y)
 * @param Orientation (N or S or W or E)
 */
case class Position(
                     coordinates: Coordinates,
                     orientation: CardinalDirection
                   ) {

  override def toString(): String = {
    s"[Coordinates : (${coordinates.x},${coordinates.y}) | Orientation : ${orientation}]\n"
  }
}



