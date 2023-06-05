package fr.publicis.sapient.mowitnow.app.parser

import fr.publicis.sapient.mowitnow.app.model.Instruction.Instruction
import fr.publicis.sapient.mowitnow.app.model.{Coordinates, Instruction, Position}

object FileParser {

  /**
   *
   * @param instructionRaw
   * @return
   */
  def parseInstructions(instructionRaw: List[Char]): List[Instruction] = {
    instructionRaw.map(ins ⇒ parseInstruction(ins))
  }

  /**
   *
   * @param instruction
   * @return
   */
  def parseInstruction(instruction: Char): Instruction = {
    instruction match {
      case Instruction.D.name ⇒ Instruction.D
      case Instruction.G.name ⇒ Instruction.G
      case Instruction.A.name ⇒ Instruction.A
    }
  }

  /**
   *
   * @param positionRaw
   * @return
   */
  def parsePosition(positionRaw: List[String]): Position = {
    positionRaw(2) match {
      case Position.N.name =>
        Position(
          Coordinates(
            positionRaw(0).toInt,
            positionRaw(1).toInt),
          Position.N
        )
      case Position.S.name =>
        Position(
          Coordinates(
            positionRaw(0).toInt,
            positionRaw(1).toInt),
          Position.S
        )
      case Position.E.name =>
        Position(
          Coordinates(
            positionRaw(0).toInt,
            positionRaw(1).toInt),
          Position.E
        )
      case Position.W.name =>
        Position(
          Coordinates(
            positionRaw(0).toInt,
            positionRaw(1).toInt),
          Position.W
        )
    }
  }
}