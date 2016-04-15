package game

import org.scalatest.FunSuite

class testClass extends FunSuite{

  test("Empty world should return empty") {
    assert(GameOfLifeController(new Array[PointInWorld](0)).length == 0)
  }

  test("a cell with no neighbours should die"){
    assert(GameOfLifeController(Array(new PointInWorld(1, 1))).length == 0)
  }

  test("a cell with 1 neighbours should die"){
    assert(GameOfLifeController(Array(new PointInWorld(1, 1))).length == 0)
  }

  test("printing"){
//    Printer(1 to 10)
    Printer(Array(new PointInWorld(1,1), new PointInWorld(3,3) ,new PointInWorld(2,2), new PointInWorld(4,4)))
    Printer() = 32
//    Printer(Array(new PointInWorld(1,1), new PointInWorld(3,3) ,new PointInWorld(2,2), new PointInWorld(4,4)))
  }
//  test("Invoking head on an empty Set should produce NoSuchElementException") {
//    intercept[NoSuchElementException] {
//      Set.empty.head
//    }
//  }

}
