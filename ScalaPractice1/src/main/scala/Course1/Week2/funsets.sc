type Set = Int => Boolean

def contains(s: Set, elem: Int): Boolean = s(elem)

def singletonSet(elem: Int): Set = (x: Int) => x == elem

def union(s: Set, t: Set): Set = (x: Int) => contains(s, x) || contains(t, x)

def intersect(s: Set, t: Set): Set = (x: Int) => contains(s, x) && contains(t, x)

def s1 = singletonSet(1)
def s2 = singletonSet(2)
def s3 = singletonSet(3)
def s = union(s3, union(s1, s2))

def set(condition: Int => Boolean): Set = (x: Int) => condition(x)
def p(x: Int): Boolean = x < 3

def filter(s: Set, p: Int => Boolean): Set =
  intersect(s, (x: Int) => p(x))

def forall(s: Set, p: Int => Boolean): Boolean = {
  def iter(a: Int): Boolean = {
    if (a > 1000) true
    else if (contains(s, a) && !p(a)) false
    else iter(a + 1)
  }
  iter(-1000)
}

def diff(s: Set, t: Set): Set = (x: Int) =>
  contains(s, x) && !contains(t, x)

print("Exists ------------------ ")

def exists(s: Set, p: Int => Boolean): Boolean = {
  !forall(s, x => !p(x))
}

def set1to100: Set = (elem: Int) => -1 < elem && 100 > elem
val st = set(x => x > 3)
val existsLessThan0 = exists(set1to100, x => x == -3)




