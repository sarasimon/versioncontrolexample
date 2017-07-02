sealed trait Day

object Sunday extends Day
object Monday extends Day

object Day{
  val values: Seq[Day] = List(Sunday,Monday)
}

Sunday: Day
Sunday: Sunday.type

