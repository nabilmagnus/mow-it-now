package fr.publicis.sapient.mowitnow.app.core

import fr.publicis.sapient.mowitnow.app.model.Coordinates.checkCoordinatesBoundaries
import fr.publicis.sapient.mowitnow.app.model.Instruction.{A, D, G, Instruction}
import fr.publicis.sapient.mowitnow.app.model.{Coordinates, Position}
import fr.publicis.sapient.mowitnow.tools.logging.Logging

class Runner extends Logging with App {

  def executeInstruction(
                          position: Position,
                          instruction: Instruction
                        ): Position = {

    val oldPosition: Position = position
    val transform: Transform = new Transform()
    val newPosition: Position = instruction match {
      case D ⇒ transform.rotateRight(position)
      case G ⇒ transform.rotateLeft(position)
      case A ⇒ transform.moveForward(position)
      case _ ⇒ throw new IllegalArgumentException("Boom")
    }

    val coordinatesStatus: Boolean = checkCoordinatesBoundaries(
      Coordinates(
        position.coordinates.x,
        position.coordinates.y
      )
    )
    val finalPosition = coordinatesStatus match {
      case true ⇒ println("OK"); newPosition
      case false ⇒ println("KO"); oldPosition
    }

    print(finalPosition.toString)
    finalPosition
  }


  /**
   *
   * @param initPosition
   * @param instructions
   * @return
   */
  def executeInstructions(initPosition: Position, instructions: List[Instruction]): Position = {
    instructions.foldLeft(initPosition)(executeInstruction)
  }

  /**
   *
   */
  private[mowitnow] def run(): Unit = ???
}
