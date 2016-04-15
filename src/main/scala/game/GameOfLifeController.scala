package game

object GameOfLifeController {


  def GetStayingPoints(points: Array[PointInWorld]): Array[PointInWorld] = {
    def runFunc(controller: PointInWorld): PointInWorld = {

    }
  }

  def GetNewLifePoints(points: Array[PointInWorld]): Array[PointInWorld] = {

  }

  def apply(points: Array[PointInWorld]): Array[PointInWorld] = points.length match {
    case 0 => points
    case _ => GetStayingPoints(points) ++ GetNewLifePoints(points)
  }
}
