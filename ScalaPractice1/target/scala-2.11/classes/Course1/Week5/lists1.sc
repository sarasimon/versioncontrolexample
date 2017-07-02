

def last[T](xs: List[T]): T = xs match {
  case List() => throw new Error("last of empty list")
  case List(x) => x
  case y :: ys => last(ys)
}

val l = List('a', 'b', 'c', 'd')
val t = last(List('a', 'b', 'c', 'd'))

val pair2 = ('a', 1)
val (letter, number) = pair2

def merge(xs: List[Int], ys: List[Int]): List[Int] =
  (xs, ys) match {
    case (Nil, s) => s
    case (s, Nil) => s
    case (x :: xt, y :: yt) =>
      if (x <= y) x :: merge(xt, ys)
      else y :: merge(xs, yt)
  }

val list3 = msort(List(1,8,7,2,7,6))


def msort(xs: List[Int]): List[Int] = {
  val n = xs.length/2
  if (n == 0) xs
  else {
//    def merge(xs: List[Int], ys: List[Int]) = ???
    val (fst, snd) = xs splitAt n
    merge(msort(fst), msort(snd))
  }
}