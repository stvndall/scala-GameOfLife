package game


object Printer {
  def apply(list:Seq[_]): Unit = list match {
    case x if x.isEmpty => {}
    case _ => {
      println(list.headOption)
      Printer(list.tail)
    }
  }
  def update (i : Int):Unit={
    println(i)
  }
}

object GameOfLifeController {
  def apply(points: Array[PointInWorld]): Array[PointInWorld] = points match {
    case x if x.length == 0 => new Array[PointInWorld](0)
    case x if x.length == 1 => {
      GameOfLifeController(new Array[PointInWorld](0))
    }
    case x if x.length > 1 && x.length < 3 => points
  }
}
