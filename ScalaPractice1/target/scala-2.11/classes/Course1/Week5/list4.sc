def nQueens(n: Int): Set[List[Int]] = {
  def placeQueens(k: Int): Set[List[Int]] = {
    if (k == 0) Set(List())
    else
      for {
        queens <- placeQueens(k - 1)
        col <- 0 until n
        if isSafe(col, queens)
      } yield col :: queens
  }

  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val rows = queens.length - 1 to 0 by -1
    val queensWithRows = rows zip queens
    queensWithRows forall {
      case (r, c) => col != c && math.abs(col - c) != queens.length - r
    }
  }
  placeQueens(n)
}

def show(queens: List[Int]) = {
  val lines : List[String] = for (q <- queens.reverse)
    yield Vector.fill(queens.length)(" *") updated(q, " Q") mkString "\\n" + (lines mkString "\\n")
}

val n = for (n <- nQueens(3)) { show(n) }