type Occurrences = List[(Char, Int)]

val xs = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
val ys = List(('a', 1), ('d', 1))
val zs = List(('r', 2))

//foldLeft[B](z: B)(op: (B, A) => B): B

xs.foldLeft(List.empty[(Char, Int)])((acc, elem) =>
  if (ys.exists(_._1 == elem._1)) acc else elem :: acc)


val a = xs toMap
val b = a('r')

isSubset((xs toMap).withDefaultValue(0), ys)

def isSubset(x: Map[Char, Int], y: Occurrences) = {
  (for {
    (letter, number) <- y
    if x(letter) < number
  } yield 1).isEmpty
}



def subtract(x: Occurrences, y: Occurrences): Occurrences = {
  def isSubset(x: Map[Char, Int], y: Occurrences) = {
    (for { (letter, number) <- y
           if x(letter) < number
    } yield 1).isEmpty
  }

  if (isSubset((x toMap).withDefaultValue(0), y))
    x.foldLeft(List.empty[(Char, Int)])((acc, elem) =>
      if (y.exists(_._1 == elem._1)) acc else acc ++ List(elem))
  else List()
}

isSubset((xs toMap).withDefaultValue(0), ys)


subtract(xs, ys)