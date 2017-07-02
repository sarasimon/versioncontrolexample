package Course2.week1

class Pouring(capacity: Vector[Int]) {
  type State = Vector[Int]
  val initialState: State = capacity map (x => 0)

  trait Moves {
    def change(state: State): State
  }

  case class Empty(glass: Int) extends Moves {
    def change(state: State): State = state updated(glass, 0)
  }

  case class Fill(glass: Int) extends Moves {
    override def change(state: State): State = state updated(glass, capacity(glass))
  }

  case class Pour(from: Int, to: Int) extends Moves {
    override def change(state: State): State = {
      val amountPoured = state(from) min (capacity(to) - state(to))
      state updated(to, state(to) + amountPoured) updated(from, state(from) - amountPoured)
    }
  }

  val numberGlasses = 0 until capacity.length

  val moves: List[Moves] =
    ((for (glass <- numberGlasses) yield Empty(glass)) ++
      (for (glass <- numberGlasses) yield Fill(glass)) ++
      (for (from <- numberGlasses; to <- numberGlasses if (from != to))
        yield Pour(from, to))).toList

  class Path(history: List[Moves], val endState: State) {
    def extend(move: Moves) = new Path(move :: history, move change endState)
    override def toString = (history.reverse mkString " ") + "--->" + endState
  }

  val initialPath = new Path(Nil, initialState)

  def from(paths: Set[Path], explored: Set[State]) : Stream[Set[Path]] =
  {
    if (paths.isEmpty) Stream.empty
    else
      {
        val more : Set[Path] = for {
          path <- paths
          next <- moves map(move => path extend(move))
          if !(explored contains next.endState)
        } yield next //next is a path

        // the loop will stop once explored contains all the possible end states
        paths #:: from(more, explored ++ more.map(path => path.endState))
      }
  }

  val pathSets = from(Set(initialPath), Set(initialState))

  def solution(target : Int) : Stream[Path] = {
    for{
      pathSet <- pathSets
      path <- pathSet
      if path.endState contains target
    } yield path
  }

}
