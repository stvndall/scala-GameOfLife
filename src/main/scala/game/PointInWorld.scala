package game

import scala.collection.immutable.IndexedSeq
import scala.collection.immutable.Range.Inclusive

/**
  * Created by steven on 2016/04/14.
  */
case class PointInWorld(locX: Int, locY: Int) {

  def createPoint(x:Int, y:Int) : PointInWorld ={
     new PointInWorld(locX + x, locY +y);
  }

  def createLocations(xLocation: Array[Int]):Array[PointInWorld] = xLocation match {
    case x if x.length == 0=> new Array[PointInWorld](0)
    case x if x.head == 0 => (for (y <- Array(-1,1)
      .filter(_!= 0 ))
      yield createPoint(xLocation.head, y)) ++ createLocations(xLocation.tail)
    case _ => (for (y <- Array(-1,0,1)
      .filter(d => {d!= 0 && xLocation.head != 0}))
      yield createPoint(xLocation.head, y)) ++ createLocations(xLocation.tail)
  }

  def Neighbours(): Seq[PointInWorld] = {
    createLocations(Array(-1,0, 1))
  }
}
