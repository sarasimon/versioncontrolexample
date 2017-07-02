def sum(f: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) 0
  else f(a) + sum(f)(a + 1, b)
}

sum(x => x + x)(1, 2)


def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1
  else f(a) * product(f)(a + 1, b)

product(x => x * x)(3, 7)

def operation(f: (Int, Int) => Int)(a: Int, b: Int, unit: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, f(a, acc))
  }
  loop(a, unit)
}

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
}

mapReduce(x => x + x, (x, y) => x + y, 0)(1, 2)
mapReduce(x => x * x, (x, y) => x * y, 1)(3, 7)

operation((x, y) => x + x + y)(1, 2, 0)
operation((x, y) => x * x * y)(3, 7, 1)