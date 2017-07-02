def squareList(xs: List[Int]): List[Int] =
  xs match {
    case Nil => xs
    case y :: ys => (y^2) :: squareList(ys)
  }

def squareList2(xs: List[Int]): List[Int] =
  xs map (x => x^2)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 => val (first, rest) = xs1 span(i => i == x); (x :: first) :: pack(rest)
}

def encode[T](xs: List[T]): List[(T,Int)] = {
  pack(xs) map (l => (l.head, l.size))
}

val l = List(1,2,3,4)
val y = reverse(l)

def reverse[T](xs: List[T]): List[T] =
  (xs foldLeft List[T]())((xy, x) => x :: xy)

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())((u,acc) => f(u) :: acc)

val m1 = mapFun[Int,Int](l, x => x*x)
val m2 = l map (x => x*x)

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)((t, i) => i + 1)

val l1 = lengthFun[Int](l)
