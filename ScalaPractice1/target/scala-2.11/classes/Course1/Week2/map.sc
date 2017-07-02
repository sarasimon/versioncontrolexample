import scala.collection

type Set = Int => Boolean

def contains(s: Set, elem: Int): Boolean = s(elem)

//def map(s: Set, f: Int => Int): Set = (x: Int) => s(f(x))

val bound = 1000
//def map(s: Set, f: Int => Int): Set = (x: Int) =>
//
//
def set(condition: Int => Boolean): Set = (x: Int) => condition(x)
//
def set1to100: Set = (elem: Int) => -1 < elem && 100 > elem
//def negatives = map(set1to100, (x: Int) => x*3)
//
//contains(negatives, 3)
def f(x: Int) = x * 3
//f(9)
def union(s: Set, t: Set): Set = (x: Int) => contains(s, x) || contains(t, x)


def map(s: Set, f: Int => Int): Set = {
  def iter(sb: Set, a: Int): Set = {
    if (a > bound) sb
    else if (contains(s, a)) union(sb, (x: Int) => x == f(a))
    else iter(sb, a + 1)
  }
  iter((x: Int) => false,-1000)
}

map(set1to100, x => x * 0)
contains(map(set1to100, x => x * 0), 1)

