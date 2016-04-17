package game

class LifeCheckers(world: Array[PointInWorld]) {
  def ShouldStayAlive(point: PointInWorld): PointInWorld = point.Neighbours().intersect(world).length match {
    case it if 2 to 3 contains it => point
    case _ => null
  }

  def collectLifeShouldBreathe(points: Seq[PointInWorld]): Array[PointInWorld] = points.length match {
    case 0 => Array()
    case x if points.head.Neighbours().intersect(world).length == 3 => points.head +: collectLifeShouldBreathe(points.tail)
    case _ =>   collectLifeShouldBreathe(points.tail)
  }

  def PointsThatShouldLightUp(listOfPoints: Array[PointInWorld] = world): Array[PointInWorld] = listOfPoints.length match{
    case 0 => Array()
    case _ => collectLifeShouldBreathe(listOfPoints.head.Neighbours()) ++ PointsThatShouldLightUp(listOfPoints.tail) distinct
  }
}
