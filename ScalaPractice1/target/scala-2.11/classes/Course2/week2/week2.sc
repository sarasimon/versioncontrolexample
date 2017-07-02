def exp = {
  lazy val x = {
    print("x"); 2
  }
  def y = {
    print("y"); 23
  }
  x+y+x
}

exp


object primes{
  def from(n: Int) : Stream[Int] = n #:: from(n + 1)

  val nats = from(0)

  def sieve(s: Stream[Int]) : Stream[Int] = {
    s.head #:: sieve(s.tail filter (_ % s.head != 0))
  }

}

primes.nats
(primes.sieve(primes.from(2)) take 10).toList
