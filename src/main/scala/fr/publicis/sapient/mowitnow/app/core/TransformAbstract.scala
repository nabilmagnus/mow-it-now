package fr.publicis.sapient.mowitnow.app.core

import fr.publicis.sapient.mowitnow.app.model.Position

abstract class TransformAbstract {

  def moveForward(initPosition: Position): Position = ???

  def rotateLeft(initPosition: Position): Position = ???

  def rotateRight(initPosition: Position): Position = ???
}
