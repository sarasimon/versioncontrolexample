

package object Course3 {

  def sumSegment(a: Array[Int], p: Double, s: Int, t: Int): Int = {
    if (s >= t) 0
    else math.pow(a(s), p).toInt + sumSegment(a, p, s + 1, t)
  }

  def pNorm(a: Array[Int], p: Double): Int = {
    math.pow(sumSegment(a, p, 0, a.length), 1 / p).toInt
  }

  def pNormTwoPart(a: Array[Int], p: Double): Int = {
    val m = a.length / 2
    val (sum1, sum2)= (sumSegment(a, p, 0, m), sumSegment(a, p, m, a.length))
    math.pow(sum1 + sum2, 1 / p).toInt
  }

}
