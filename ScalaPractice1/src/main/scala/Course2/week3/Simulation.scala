package Course2.week3

trait Simulation {
  //takes an empty parameter list and returns unit
  type Action = () => Unit
  case class Event(time: Int, action: Action)
  private type Agenda = List[Event]
  private var agenda : Agenda = List()

  private var curtime = 0
  def currentTime: Int = curtime

  private def insert(ag: List[Event], item: Event): List[Event] = ag match {
    case first :: rest if first.time <= item.time => first :: insert(rest,item)
    case _ => item :: ag

  }

  def afterDelay(delay: Int)(block: => Unit): Unit = {
    val item = Event(currentTime + delay, () => block)
    agenda = insert(agenda, item)
  }

  def run(): Unit ={
    afterDelay(0){
      println("*sim started, time = " + currentTime)
    }
    loop()
  }

  def loop(): Unit = agenda match {
    case first :: rest =>
      agenda = rest
      curtime = first.time
      first.action()
      loop()
    case Nil =>
  }


}
