// all the methods in an object will be static methods
// (class methods)

// companions (object and class with the same name)
object A {
  private val m = 10
  def n = "a"
}

class A{
  A.m
}

A.n

A: AnyRef
A: A.type

val x = "abc"
val y = "abc"
val z = y

x: AnyRef
x: String
x: x.type
y: y.type
z: z.type




