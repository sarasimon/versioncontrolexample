import day3.StringExt.RichString

"persons".pluralize.pluralize
"aaaaa".capitalize


val a = Option(10)

val string2List: String => List[Char] = str => str.toList
val list2Int: List[Char] => Int = list => list.size

val a2 = (string2List andThen list2Int)("aaaabc")

object A{
  def sayHello(x: {def squeak: String}) = {
    println(s"Hello ${x.squeak}")
  }

  class Cat {
    def squeak: String = "mew"
  }
}

A.sayHello(new A.Cat)

object B{

  type Squeak = {

  }

  def sayHello(x: {def squeak: String}) = {
    println(s"Hello ${x.squeak}")
  }

  class Cat {
    def squeak: String = "mew"
  }
}

