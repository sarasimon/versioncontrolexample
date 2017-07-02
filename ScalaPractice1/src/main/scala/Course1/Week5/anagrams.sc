
type Word = String
type Sentence = List[Word]
type Occurrences = List[(Char, Int)]

def wordOccurrences(w: Word): Occurrences = {
  w.groupBy(identity).map(c => (c._1, c._2.length)).toList
}

wordOccurrences("patata")

def sentenceOccurrences(s: Sentence): Occurrences = {
  wordOccurrences(concatenate(s))
}

val a: Word = "patata"
val b: Word = "atapat"
val c: Word = "casa"
val ab: Sentence = List(a, b, c)

def concatenate(l: Sentence): Word = l match {
  case Nil => ""
  case x :: xs => x + concatenate(xs)
}

concatenate(ab)
sentenceOccurrences(ab)

//Map[Occurrences,List[(Word, Occurrences)]]
val paraules = (ab map (w => w -> wordOccurrences(w)) groupBy (t => t._2)).map(t => (t._1, t._2.map(t2 => t2._1)))
paraules.find(_._1 == wordOccurrences("ttaaap")) map (_._2) match {
  case Some(x) => x
  case None => Nil
}

val variacions = combinations(List(('a', 2), ('b', 2)))

def combinations(occurrences: Occurrences): List[Occurrences] = {
  if (occurrences.isEmpty)
    List(List())
  else {
    for {
      combi <- combinations(occurrences.tail)
      (letter, number) = occurrences.head
      counter <- 0 to number
    } yield {
      if (counter > 0) (letter, counter) :: combi
      else combi
    }
  }
}

