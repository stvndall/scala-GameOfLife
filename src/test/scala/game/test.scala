package game

import org.scalatest.FunSuite

class testClass extends FunSuite{

  test("Empty world should return empty") {
new GameOfLifeController.GenerateWorld()
  }

//  test("Invoking head on an empty Set should produce NoSuchElementException") {
//    intercept[NoSuchElementException] {
//      Set.empty.head
//    }
//  }

}
