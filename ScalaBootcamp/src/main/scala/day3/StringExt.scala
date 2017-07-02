package day3

object StringExt {
  // extensions methods implicits
  // value class can't have statements inside constructor
  implicit class RichString(val str: String) extends AnyVal{
//    println("hello")
    def pluralize: String = s"${str}s"
  }

}
