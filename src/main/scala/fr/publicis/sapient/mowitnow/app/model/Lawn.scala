package fr.publicis.sapient.mowitnow.app.model

object Lawn {

  /**
   * Sealed trait with corner positions
   */
  sealed trait CornerPosition {
    def x: Int
    def y: Int
  }

  case object UpperRightCornerPosition {
    val x: Int = YMaxLawnSize
    val y: Int = XMaxLawnSize
  }

  case object LowerLeftCornerPosition {
    val x: Int = YMinLawnSize
    val y: Int = XMinLawnSize
  }

  case class UnknownCornerPosition(x: Int, y: Int) extends CornerPosition
}
