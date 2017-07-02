sealed trait Day

object Sunday extends Day
object Monday extends Day

object Day{
  val values: Seq[Day] = List(Sunday,Monday)
}

Sunday: Day
Sunday: Sunday.type

"""
  | aaaa
  | aaaa
  | a
""".stripMargin

val Parser = """(\d+)-(\d+)-(\d+)""".r

val Parser(day,month,u) = "23-04-1991"

val `my name is sara` : Int = 10

`my name is sara`

class Meter(private val value: Int){
  def sum(other: Meter) = other.value + value
}

object A {

}

val m : Meter = new Meter(100)
val a = A







