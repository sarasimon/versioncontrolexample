import data.AliceData._

val stopWords = stopWordText.split(stopWordRegex).toSet
val wordsAliceInWonderland = bookText.split(bookRegex).toList.sortWith(_ < _)

val cleanWords = wordsAliceInWonderland.filterNot(stopWords)

val listWords = cleanWords.groupBy(identity).mapValues(_.size).toList.sortBy(-_._2)
val top10 = listWords.map(_._1) take (10)

def top10words(bookWords: List[(String, Int)], noWords: Set[String], acc: List[String]): List[String] = {
  if (noWords.contains(bookWords.head._1)) top10words(bookWords.tail, noWords, acc)
  else if (acc.size > 10) acc
  else top10words(bookWords.tail, noWords, bookWords.head._1 :: acc)
}

val top102 = top10words(wordsAliceInWonderland.groupBy(identity).mapValues(_.size).toList.sortBy(-_._2),stopWords,List.empty)