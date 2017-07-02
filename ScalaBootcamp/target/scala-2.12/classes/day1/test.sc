//trait Function1[S, T]{
//  def apply(value: S) : T
//}

//class IndianPersonCanDrinkForAge extends (Int => Boolean) {
//  def apply(age: Int): Boolean = age > 30
//}

val indianPersonCanDrinkForAge = new (Int => Boolean) {
  def apply(age: Int): Boolean = age > 30
}

// lambda function
val canDrink: Int => Boolean = {
  age => age > 30
}

def canDrink2(age : Int) = age > 30

val a0 = canDrink
val a3 = canDrink2 _

  //ETA expansion

class Person(age: Int, isFemale: Boolean) {

  def canMarry(canDrinkForAge: Int => Boolean): Boolean = {
    canDrinkForAge(age) // apply method is implicit, functions are objects
  }
}

