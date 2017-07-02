
def isEmpty[T](option: Option[T]): Boolean = option match {
  case None => true
}

def add(option1: Option[Int], option2: Option[Int]): Option[Int] = {
  (option1, option2) match {
    case (Some(x), Some(y)) => Some(x + y)
    case (None, _) => option2
    case (_, None) => option1
  }
}

def length[T](xs: List[T]): Int = xs match {
  case Nil => 0
  case h :: t => 1 + length(t)
}

val a = List(1,2,3)
val l = length(a)

// 1st convention
val x: Function1[Int, Boolean]
val x2: Int Function1 Boolean

//  a :: b == ::(a,b)

