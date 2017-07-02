import scala.List

//cons = prepending adding one element to the list

// sharing the same object would create problems if
// the object was mutable (if it was allowed to be changed)
// immutable stack

val a = Nil
val b = 2 :: 3 :: a
val c = List("a", "b", "c")

// lambda expressions can be used in single abstract method
trait SAM {
  def invoke(x: Int) : Int
}

val sam2 : SAM = x => x*x

val c1 = c.apply(1)
// the value of a scala collection is a function
c: List[String]
c: Int => String

// apply returns a boolean (is a contains)
val ys = Set(1,2,3,4)
ys: Int => Boolean