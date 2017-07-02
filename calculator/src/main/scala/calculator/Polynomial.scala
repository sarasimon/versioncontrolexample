package calculator

object Polynomial {
  def computeDelta(a: Signal[Double], b: Signal[Double],
                   c: Signal[Double]): Signal[Double] = {
    Signal(b() * b() - 4 * a() * c())
  }

  // (-b ± √Δ) / 2a
  def computeSolutions(a: Signal[Double], b: Signal[Double],
                       c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {

    Signal{
      val pos = -b() + math.sqrt(delta())
      val neg = -b() - math.sqrt(delta())
      val den = 2 * a()

      if (delta() < 0)
        Set()
      else if (pos == neg)
        Set(pos / den)
      else
        Set(pos / den, neg / den)
    }
  }
}
