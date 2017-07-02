class Account(var amount: Int = 0) {
  def transfer(target: Account, n: Int) =
    this.synchronized {
      target.synchronized {
        this.amount -= n
        target.amount += n
      }
    }
}

def startThread(a: Account, b: Account, n:Int) = {
  val t = new Thread{
    override def run(): Unit = {
      for (i <- 0 until n)
        a.transfer(b, 1)
    }
  }
  t.start()
  t
}

val a1 = new Account(50)
val a2 = new Account(70)

//val t1 = startThread(a1, a2, 10)
//val t2 = startThread(a2, a1, 10)
//t1.join()
//t2.join()

a1.transfer(a2, 20)
a2.transfer(a1, 10)

a1.amount
a2.amount