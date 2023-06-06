package fr.publicis.sapient.mowitnow.app.core

import fr.publicis.sapient.mowitnow.app.io.GetResource
import fr.publicis.sapient.mowitnow.app.model.Position.{E, N, S, W}
import fr.publicis.sapient.mowitnow.app.model._
import org.junit.runner.RunWith
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.junit.JUnitRunner

/**
 * =TransformTest=
 */
@RunWith(classOf[JUnitRunner])
class TransformTest extends AnyWordSpec
  with Matchers
  with GetResource {

  def moveForward(initPosition: Position): Position = {
    new Transform().moveForward(initPosition)
  }

  def rotateLeft(initPosition: Position): Position = {
    new Transform().rotateLeft(initPosition)
  }

  def rotateRight(initPosition: Position): Position = {
    new Transform().rotateRight(initPosition)
  }

  "moveForward() 1 steps to the N" should {
    "return Postition(1,3,'N')" in {
      val lawnMowerPosition = new Position(Coordinates(1, 2), N)
      val expectedPosition = new Position(Coordinates(1, 3), N)
      val newLawnMowerPosition: Position = moveForward(lawnMowerPosition)

      println(newLawnMowerPosition)
      assert(newLawnMowerPosition == expectedPosition)
    }
  }

  "moveForward() 1 steps to the S" should {
    "return Postition(1,3,'S')" in {
      val lawnMowerPosition = new Position(Coordinates(1, 2), S)
      val expectedPosition = new Position(Coordinates(1, 1), S)
      val newLawnMowerPosition: Position = moveForward(lawnMowerPosition)

      println(newLawnMowerPosition)
      assert(newLawnMowerPosition == expectedPosition)
    }
  }

  "moveForward() 1 steps to the E" should {
    "return Postition(0,2,'E')" in {
      val lawnMowerPosition = new Position(Coordinates(1, 2), E)
      val expectedPosition = new Position(Coordinates(2, 2), E)
      val newLawnMowerPosition: Position = moveForward(lawnMowerPosition)

      println(newLawnMowerPosition)
      assert(newLawnMowerPosition == expectedPosition)
    }
  }

  "moveForward() 1 steps to the W" should {
    "return Postition(2,2,'W')" in {
      val lawnMowerPosition = new Position(Coordinates(1, 2), W)
      val expectedPosition = new Position(Coordinates(0, 2), W)
      val newLawnMowerPosition: Position = moveForward(lawnMowerPosition)

      println(newLawnMowerPosition)
      assert(newLawnMowerPosition == expectedPosition)
    }
  }

  "rotateLeft() from N turn 90 degree to the left" should {
    "return Postition(1,2,'W')" in {
      val lawnMowerPosition = new Position(Coordinates(1, 2), N)
      val expectedPosition = new Position(Coordinates(1, 2), W)
      val newLawnMowerPosition: Position = rotateLeft(lawnMowerPosition)

      println(newLawnMowerPosition)
      assert(newLawnMowerPosition == expectedPosition)
    }
  }

  "rotateLeft() from S turn 90 degree to the left" should {
    "return Postition(1,2,'E')" in {
      val lawnMowerPosition = new Position(Coordinates(1, 2), S)
      val expectedPosition = new Position(Coordinates(1, 2), E)
      val newLawnMowerPosition: Position = rotateLeft(lawnMowerPosition)

      println(newLawnMowerPosition)
      assert(newLawnMowerPosition == expectedPosition)
    }
  }

  "rotateLeft() from E turn 90 degree to the left" should {
    "return Postition(1,2,'N')" in {
      val lawnMowerPosition = new Position(Coordinates(1, 2), E)
      val expectedPosition = new Position(Coordinates(1, 2), N)
      val newLawnMowerPosition: Position = rotateLeft(lawnMowerPosition)

      println(newLawnMowerPosition)
      assert(newLawnMowerPosition == expectedPosition)
    }
  }

  "rotateLeft() from W turn 90 degree to the left" should {
    "return Postition(1,2,'S')" in {
      val lawnMowerPosition = new Position(Coordinates(1, 2), W)
      val expectedPosition = new Position(Coordinates(1, 2), S)
      val newLawnMowerPosition: Position = rotateLeft(lawnMowerPosition)

      println(newLawnMowerPosition)
      assert(newLawnMowerPosition == expectedPosition)
    }
  }

  "rotateRight() from N turn 90 degree to the left" should {
    "return Postition(1,2,'E')" in {
      val lawnMowerPosition = new Position(Coordinates(1, 2), N)
      val expectedPosition = new Position(Coordinates(1, 2), E)
      val newLawnMowerPosition: Position = rotateRight(lawnMowerPosition)

      println(newLawnMowerPosition)
      assert(newLawnMowerPosition == expectedPosition)
    }
  }

  "rotateRight() from S turn 90 degree to the left" should {
    "return Postition(1,2,'W')" in {
      val lawnMowerPosition = new Position(Coordinates(1, 2), S)
      val expectedPosition = new Position(Coordinates(1, 2), W)
      val newLawnMowerPosition: Position = rotateRight(lawnMowerPosition)

      println(newLawnMowerPosition)
      assert(newLawnMowerPosition == expectedPosition)
    }
  }

  "rotateRight() from E turn 90 degree to the left" should {
    "return Postition(1,2,'S')" in {
      val lawnMowerPosition = new Position(Coordinates(1, 2), E)
      val expectedPosition = new Position(Coordinates(1, 2), S)
      val newLawnMowerPosition: Position = rotateRight(lawnMowerPosition)

      println(newLawnMowerPosition)
      assert(newLawnMowerPosition == expectedPosition)
    }
  }

  "rotateRight() from W turn 90 degree to the left" should {
    "return Postition(1,2,'N')" in {
      val lawnMowerPosition = new Position(Coordinates(1, 2), W)
      val expectedPosition = new Position(Coordinates(1, 2), N)
      val newLawnMowerPosition: Position = rotateRight(lawnMowerPosition)

      println(newLawnMowerPosition)
      assert(newLawnMowerPosition == expectedPosition)
    }
  }

}