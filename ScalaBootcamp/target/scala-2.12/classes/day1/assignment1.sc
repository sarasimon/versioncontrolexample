import scala.annotation.tailrec
import scala.collection.mutable.Buffer

trait SAM {
  def apply(x: Int) : Int
}

val xs = List(1, 2, 3, 4)

xs map (x => x * x) // lambda syntax

val square: Int => Int = {
  x => x * x
}

def square2(x: Int): Int = x * x
xs map square2


def map(xs: List[Int], f: Int => Int): List[Int] = {

  // not to create iterator every time, it wouldn't save the changes
  val it = xs.iterator

  // buffer is a mutable object which is implicit with the object
  val result: Buffer[Int] = Buffer.empty[Int]

  while (it.hasNext) {
    result += f(it.next())
  }
  result.toList
}

// Functional programming doesn't use mutation at all!

def map2(xs: List[Int], f: SAM): List[Int] = {

  val it = xs.iterator
  // var makes the mutability in the program
  // var is mutable reference, the reference is pointing to an object but that
  // can change, to an object of the same type
  var res: List[Int] = Nil

  while (it.hasNext) {
    // creating a new list (object) in every step
    res = f(it.next()) :: res
  }

  // returns the object that res points to
  res.reverse
}

// this will exceed the stack for long lists
// never completing the method
// every time trying to complete a method it will open a new stack
// not tail recursive
// for tail recursive functions the compiler is able to reuse the stack
// because the ending function is itself
def map3(xs: List[Int], f: Int => Int): List[Int] = {
  @tailrec
  def recursion(xs2: List[Int], res: List[Int]) : List[Int] =
    if(xs2.isEmpty) res
    else recursion(xs2.tail, f(xs2.head) :: res)

  recursion(xs, List.empty).reverse
}

@tailrec
def map4(xs: List[Int], f: Int => Int, acc: List[Int]): List[Int] = {
  if(xs.isEmpty) acc
  else map4(xs.tail, f, f(xs.head) :: acc)
}

def map5[A,B](xs: List[A], f: A => B): List[B] = xs match {
    case Nil => Nil
    case h :: t => f(xs.head) :: map5(xs.tail, f)
}

val ys = map5[Int,Int]((1 to 10).toList, x => x * x)