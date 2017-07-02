
def map[T,T2](xs: List[T])(f: T => T2): List[T2] = {
  xs.foldLeft(List.empty[T2]) { (acc, elem) =>
    f(elem) :: acc
  }.reverse
}

def reverse[T](xs: List[T]): List[T] = {
  xs.foldLeft(List.empty[T])((acc,elem) => elem :: acc)
}

reverse(List(1,2,3,100))

val xs = List(1,2,3,100)
xs.reduceLeft((a, b) => if(a < b) b else a)