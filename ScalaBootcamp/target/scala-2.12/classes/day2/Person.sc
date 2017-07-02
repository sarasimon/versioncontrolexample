// value object: defined by its attributes
// case syntax - use value objects for domain models

// if there is no setter, we need a copy method

//concurrency appears with the mutability of objects

// enumerations are opposite to OOP given that they unable extension

case class Person(name: String, age: Int) {
  //helper methods won't contribute to identity
}

val p = new Person("Pepito", 100)
val p2 = new Person("Pepito", 100)

p == p2

val copy = p.copy()
val copy2 = p.copy(name = "Mike")


