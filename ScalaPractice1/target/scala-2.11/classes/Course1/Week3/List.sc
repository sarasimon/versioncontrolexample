trait List[T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true

  def head = throw new NoSuchElementException("Nil.head")

  def tail = throw new NoSuchElementException("Nil.tail")
}

def nth[T](list: List[T], n: Int): T = {
  if (n == 0) list.head
  else nth(list.tail, n - 1)
}

def con: Cons[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, new Nil[Int])))

val number = nth(con, 3)

object List {

  def apply[T](): List[T] = new Nil

  def apply[T](first: T, second: T) : List[T] = new Cons[T](first, new Cons[T](second, new Nil))
}

def tlist = List.apply(1,2)