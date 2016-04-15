package game

import scala.collection.GenTraversableOnce

/**
  * Created by steven on 2016/04/15.
  */
object LifeCheckers {
  def ShouldStayAlive(point: PointInWorld, world: Array[PointInWorld]): PointInWorld = point.Neighbours().intersect(world).length match {
    case it if 2 to 3 contains it => point
    case _ => null
  }

  def collectLifeShouldBreathe(points: Seq[PointInWorld], allPoints : Seq[PointInWorld]): Array[PointInWorld] = points.length match {
    case 0 => Array()
    case it if points.head.Neighbours().intersect(allPoints).length == 3 => points.head +: collectLifeShouldBreathe(points.tail, allPoints)
    case _ =>   collectLifeShouldBreathe(points.tail, allPoints)
  }

  def PointsThatShouldLightUp(listOfPoints: Array[PointInWorld], allPoints: Seq[PointInWorld]): Array[PointInWorld] = listOfPoints.length match{
    case 0 => Array()
    case _ => collectLifeShouldBreathe(listOfPoints.head.Neighbours().diff(allPoints), allPoints) ++ PointsThatShouldLightUp(listOfPoints.tail, allPoints)
  }

  def PointsThatShouldLightUp(listOfPoints: Array[PointInWorld]): Array[PointInWorld] = PointsThatShouldLightUp(listOfPoints, listOfPoints).distinct

}
