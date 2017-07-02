import common.{DefaultTaskScheduler, TaskScheduler}

import scala.util.DynamicVariable

def sumSegment(a: Array[Int], p: Double, s: Int, t: Int): Int = {
  if (s >= t) 0
  else math.pow(a(s), p).toInt + sumSegment(a, p, s + 1, t)
}

def pNorm(a: Array[Int], p: Double): Int = {
  math.pow(sumSegment(a, p, 0, a.length), 1 / p).toInt
}

val scheduler =
  new DynamicVariable[TaskScheduler](new DefaultTaskScheduler)

def pNormTwoPart(a: Array[Int], p: Double): Int = {
  val m = a.length / 2
  val (sum1, sum2) = scheduler.value.parallel(sumSegment(a, p, 0, m), sumSegment(a, p, m, a.length))
  math.pow(sum1 + sum2, 1 / p).toInt
}

sumSegment(Array[Int](4, 3), 2.0, 0, 2)
pNormTwoPart(Array[Int](4, 3), 2)