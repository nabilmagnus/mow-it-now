package fr.publicis.sapient.mowitnow.app.core

import fr.publicis.sapient.mowitnow.app.model.Instruction.{A, D, G, Instruction}
import fr.publicis.sapient.mowitnow.app.model.Position.{E, N, W}
import fr.publicis.sapient.mowitnow.app.model.{Coordinates, Position}
import org.junit.runner.RunWith
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.junit.JUnitRunner


/**
 * =RunnerTest=
 */
@RunWith(classOf[JUnitRunner])
class RunnerTest
  extends AnyWordSpec
    with Matchers {

  def executeInstruction(initPosition: Position, instruction: Instruction): Position = {
    new Runner().executeInstruction(initPosition, instruction)
  }

  def executeInstructions(initPosition: Position, instructions: List[Instruction]): Position = {
    new Runner().executeInstructions(initPosition, instructions)
  }

  "executeInstruction() when (0,0,N)" should {
    "return (0,1,N)" in {
      val runner: Runner = new Runner
      val initPosition: Position = Position(Coordinates(0, 0), N)
      val expectedPosition: Position = Position(Coordinates(0, 1), N)
      val transformedPosition: Position = runner.executeInstruction(initPosition, A)
      assert(transformedPosition == expectedPosition)
    }
  }

  "executeInstruction() when (0,0,N)" should {
    "return (0,0,E)" in {
      val initPosition: Position = Position(Coordinates(0, 0), N)
      val expectedPosition: Position = Position(Coordinates(0, 0), E)
      val transformedPosition: Position = executeInstruction(initPosition, D)
      assert(transformedPosition == expectedPosition)
    }
  }

  "executeInstruction() when (0,0,N)" should {
    "return (0,0,W)" in {
      val initPosition: Position = Position(Coordinates(0, 0), N)
      val expectedPosition: Position = Position(Coordinates(0, 0), W)
      val transformedPosition: Position = executeInstruction(initPosition, G)
      assert(transformedPosition == expectedPosition)
    }
  }

  "executeInstructions() when (0,0,N)" should {
    "return (0,1,N)" in {
      val initPosition: Position = Position(Coordinates(0, 0), N)
      val expectedPosition: Position = Position(Coordinates(0, 1), N)
      val transformedPosition: Position = executeInstructions(initPosition, List(A, D, G))
      assert(transformedPosition == expectedPosition)
    }
  }
}