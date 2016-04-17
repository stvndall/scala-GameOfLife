package game

object GameOfLifeController {


  def GetStayingPoints(lc: LifeCheckers,points: Array[PointInWorld]): Array[PointInWorld] = points.length match{
    case 0 => Array()
    case _ => lc.ShouldStayAlive(points.head) +: GetStayingPoints(lc, points.tail)
  }

  def GetNewLifePoints(lc: LifeCheckers, points: Array[PointInWorld]): Array[PointInWorld] = {
    lc.PointsThatShouldLightUp()
  }

  def apply(points: Array[PointInWorld]): Array[PointInWorld] = {
    GetStayingPoints(new LifeCheckers(points),points).filter(cell => cell != null) ++ GetNewLifePoints(new LifeCheckers(points), points).filter(cell => cell != null)
  }
}
