package game

import org.scalatest.FunSuite

class testClass extends FunSuite {

  test("Empty world should return empty") {
    assert(GameOfLifeController(new Array[PointInWorld](0)).length == 0)
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
}
