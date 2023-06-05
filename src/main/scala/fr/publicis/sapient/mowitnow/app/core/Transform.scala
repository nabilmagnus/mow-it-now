package fr.publicis.sapient.mowitnow.app.core

import fr.publicis.sapient.mowitnow.app.model._

class Transform extends TransformAbstract {

  /**
   * Move forward
   *
   * @param initPosition
   * @return
   */
  override def moveForward(initPosition: Position): Position = {
    val newPosition: Position = initPosition.orientation.name match {
      case Position.N.name ⇒ Position(
        Coordinates(initPosition.coordinates.x, initPosition.coordinates.y + Step),
        initPosition.orientation
      )
      case Position.S.name ⇒ Position(
        Coordinates(initPosition.coordinates.x, initPosition.coordinates.y - Step),
        initPosition.orientation
      )
      case Position.E.name ⇒ Position(
        Coordinates(initPosition.coordinates.x + Step, initPosition.coordinates.y),
        initPosition.orientation
      )
      case Position.W.name ⇒ Position(
        Coordinates(initPosition.coordinates.x - Step, initPosition.coordinates.y),
        initPosition.orientation
      )
      case _ ⇒ throw new IllegalArgumentException("BOOM")
    }
    newPosition
  }

  /**
   *
   * @param initPosition
   * @return
   */
  override def rotateLeft(initPosition: Position): Position = {
    val newPosition: Position = initPosition.orientation.name match {
      case Position.N.name ⇒ Position(
        Coordinates(initPosition.coordinates.x, initPosition.coordinates.y),
        Position.W
      )
      case Position.S.name ⇒ Position(
        Coordinates(initPosition.coordinates.x, initPosition.coordinates.y),
        Position.E
      )
      case Position.E.name ⇒ Position(
        Coordinates(initPosition.coordinates.x, initPosition.coordinates.y),
        Position.N
      )
      case Position.W.name ⇒ Position(
        Coordinates(initPosition.coordinates.x, initPosition.coordinates.y),
        Position.S
      )
      case _ ⇒ throw new IllegalArgumentException("BOOM")
    }
    newPosition
  }


  override def rotateRight(initPosition: Position): Position = {
    val newPosition: Position = initPosition.orientation.name match {
      case Position.N.name ⇒ Position(
        Coordinates(initPosition.coordinates.x, initPosition.coordinates.y),
        Position.E
      )
      case Position.S.name ⇒ Position(
        Coordinates(initPosition.coordinates.x, initPosition.coordinates.y),
        Position.W
      )
      case Position.E.name ⇒ Position(
        Coordinates(initPosition.coordinates.x, initPosition.coordinates.y),
        Position.S
      )
      case Position.W.name ⇒ Position(
        Coordinates(initPosition.coordinates.x, initPosition.coordinates.y),
        Position.N
      )
      case _ ⇒ throw new IllegalArgumentException("BOOM")
    }
    newPosition
  }
}
