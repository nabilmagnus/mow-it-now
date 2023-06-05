package fr.publicis.sapient.mowitnow.app.model

object Instruction {

  /**
   * Sealed trait with four directions possibility
   */
  sealed trait Instruction {
    def name: Char
  }

  case object D extends Instruction {
    val name: Char = 'D'
  } //etc.

  case object G extends Instruction {
    val name: Char = 'G'
  } //etc.

  case object A extends Instruction {
    val name: Char = 'A'
  } //etc.

  case class UnknownInstruction(name: Char) extends Instruction
}
