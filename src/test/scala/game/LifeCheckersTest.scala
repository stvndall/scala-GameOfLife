package game

/**
  * Created by steven on 2016/04/15.
  */
import org.scalatest.FunSuite
class LifeCheckersTest extends FunSuite {

  test("a cell with no neighbours in list should return null"){
    assert(new LifeCheckers(Array(new PointInWorld(1,1))).ShouldStayAlive(new PointInWorld(1,1)) == null)
  }

  test("a cell with 2 neighbours in list should return itself"){
    assert(new LifeCheckers(Array(new PointInWorld(1,0), new PointInWorld(0,1))).ShouldStayAlive(new PointInWorld(1,1)) == new PointInWorld(1,1))
  }

  test("a cell with 3 neighbours in list should return itself"){
    assert(new LifeCheckers(Array(new PointInWorld(1,0), new PointInWorld(0,1), new PointInWorld(0,0))).ShouldStayAlive(new PointInWorld(1,1)) == new PointInWorld(1,1))
  }

  test("a cell with 4 neighbours in list should return null"){
    assert(new LifeCheckers(Array(new PointInWorld(1,0), new PointInWorld(0,1), new PointInWorld(0,0), new PointInWorld(2,2))).ShouldStayAlive(new PointInWorld(1,1)) == null)
  }

  test("a dead cell should be returned if exactly 3 neighbours in world"){
    val deadArray: Array[PointInWorld] =new  LifeCheckers(Array(new PointInWorld(1, 0), new PointInWorld(0, 1), new PointInWorld(-1, 0))).PointsThatShouldLightUp()
    assert(deadArray.length == 1 && deadArray.contains(new PointInWorld(0,0)))
  }

  test("if there are no dead cells that should come alive then there should be no array of live dead cells coming back"){
    assert(new LifeCheckers(Array()).PointsThatShouldLightUp().length == 0)
  }



}
