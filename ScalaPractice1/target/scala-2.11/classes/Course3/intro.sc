private val x = new AnyRef {}
private var uniqueId = 0L

def getUniqueId() : Long = x.synchronized {
  uniqueId = uniqueId + 1
  uniqueId
}

def newThread() = {
  val t = new Thread {
    override def run() = {
      val uids = for (i <- 0 to 10) yield getUniqueId
      println(uids)
    }
  }
  t.start()
  t
}

newThread()
newThread()