package game

import scala.collection.GenTraversableOnce

/**
  * Created by steven on 2016/04/15.
  */
class LifeCheckers(world: Array[PointInWorld]) {
  def ShouldStayAlive(point: PointInWorld): PointInWorld = point.Neighbours().intersect(world).length match {
    case it if 2 to 3 contains it => point
    case _ => null
  }

  def collectLifeShouldBreathe(points: Seq[PointInWorld]): Array[PointInWorld] = points.length match {
    case 0 => Array()
    case it if points.head.Neighbours().intersect(world).length == 3 => points.head +: collectLifeShouldBreathe(points.tail)
    case _ =>   collectLifeShouldBreathe(points.tail)
  }

  def PointsThatShouldLightUp(listOfPoints: Array[PointInWorld] = world): Array[PointInWorld] = listOfPoints.length match{
    case 0 => Array()
    case _ => (collectLifeShouldBreathe(listOfPoints.head.Neighbours().diff(world)) ++ PointsThatShouldLightUp(listOfPoints.tail)) distinct
  }

//  def PointsThatShouldLightUp() : Array[PointInWorld] = PointsThatShouldLightUp(world)
}
