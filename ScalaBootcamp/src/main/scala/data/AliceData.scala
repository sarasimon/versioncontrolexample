package data

import scala.io.Source

object AliceData {
  val bookText = Source.fromFile(
    "/Users/sarasimonwillis-fleming/ScalaBootcamp/src/main/scala/data/aliceInWonderland.txt").mkString.toLowerCase
  val stopWordText = Source.fromFile(
    "/Users/sarasimonwillis-fleming/ScalaBootcamp/src/main/scala/data/stopWords.txt").mkString.toLowerCase

  val bookRegex = """[\s|:|.|,|"]+"""
  val stopWordRegex = "\\s+"
}