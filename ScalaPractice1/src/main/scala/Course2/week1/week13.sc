import java.util.Random

trait Generator[+T] {
  me =>

  def generate: T

  def map[S](f: T => S): Generator[S] = new Generator[S] {
    def generate: S = f(me.generate)
  }

  def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
    // generate function is of type S and the function f returns a Generator
    def generate: S = f(me.generate).generate
  }

  def filter[S](): Generator[S] = new Generator[S] {
    override def generate: S = ???
  }
}

val integers = new Generator[Int] {
  val rand = new Random

  def generate = rand.nextInt()
}

val answer: String = integers.map(x => x + "S").generate

val booleans: Generator[Boolean] = new Generator[Boolean] {
  def generate = integers.generate > 0
}

def pairs[T, U](t: Generator[T], u: Generator[U]) = new Generator[(T, U)] {
  def generate = (t.generate, u.generate)
}

def single[T](x: T): Generator[T] = new Generator[T] {
  def generate = x
}

val emptyList = single(Nil)

val nonEmptyList = for {
  head <- integers
  tail <- lists
} yield head :: tail

def lists: Generator[List[Int]] = for {
  isEmpty <- booleans
  list <- if (isEmpty) emptyList else nonEmptyList
} yield list

trait Tree

case class Inner(left: Tree, right: Tree) extends Tree

case class Leaf(x: Int) extends Tree

val leafs: Generator[Tree] = for {
  i <- integers
} yield Leaf(i)

val inner = for {
  r <- trees
  l <- trees
} yield Inner(r, l)

def trees: Generator[Tree] = for {
  isLeaf <- booleans
  tree <- if (isLeaf) leafs else inner
} yield tree

val l1 = lists.generate
val t1 = trees.generate

def test[T](g: Generator[T], numTimes: Int = 100)
           (test: T => Boolean): Unit = {
  for (i <- 0 until numTimes) {
    val value = g.generate
    assert(test(value), "test failed for" +value)
  }
  println("passed " +numTimes+ " tests")
}

test(pairs(lists,lists), 100){
  case(xs, ys) => (xs ++ ys).size > xs.size + ys.size
}

