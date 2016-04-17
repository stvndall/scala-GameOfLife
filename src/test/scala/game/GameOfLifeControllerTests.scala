package game

import org.scalatest.FunSuite

class GameOfLifeControllerTests extends FunSuite {

  test("Empty world should return empty") {
    assert(GameOfLifeController(Array()).length == 0)
  }

  test("a cell with no neighbours should die") {
    assert(GameOfLifeController(Array(new PointInWorld(1, 1))).length == 0)
  }

  test("a cell with 1 neighbours should die") {
    assert(GameOfLifeController(Array(new PointInWorld(1, 1))).length == 0)
  }

  test("Point in world should return 8 neighbours") {
    assert(PointInWorld(1, 1).Neighbours().distinct.length == 8)
  }

  test("spinner should rotate") {
    val arrayOfPoints = GameOfLifeController(Array(new PointInWorld(1, 1), new PointInWorld(1, 0), new PointInWorld(1, -1)))
    val expected = Array(new PointInWorld(1, 0), new PointInWorld(2, 0), new PointInWorld(0, 0))
    assert(arrayOfPoints.length == 3)
    for (i <- arrayOfPoints) {
      assert(expected.contains(i))
    }
  }

  test("block should stay static") {
    val block: Array[PointInWorld] = Array(new PointInWorld(1, 1), new PointInWorld(1, 0), new PointInWorld(0, 1), new PointInWorld(0, 0))
    val arrayOfPoints = GameOfLifeController(block)
    val expected = Array(new PointInWorld(1, 1), new PointInWorld(1, 0), new PointInWorld(0, 1), new PointInWorld(0, 0))
    assert(arrayOfPoints.length == 4)
    for (i <- arrayOfPoints) {
      assert(expected.contains(i))
    }

    //    assert(arrayOfPoints.sameElements())
    //    assert(arrayOfPoints.contains(new PointInWorld(0, 0)))
    //    assert(arrayOfPoints.contains(new PointInWorld(1, 0)))
    //    assert(arrayOfPoints.contains(new PointInWorld(2, 0)))
  }
}

