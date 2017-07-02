def sum(xs: List[Int]): Int =
{
  def loop(xs: List[Int], acc: Int) : Int =
    if(xs.isEmpty)
      acc
    else
     loop(xs.tail,acc + xs.head)

  loop(xs,0)
}

def pascal(c: Int, r: Int): Int = {
  if (c == 0 || c == r)
    1
  else
    pascal(c - 1, r - 1) + pascal(c, r - 1)
}

pascal(1,3)

val list = List(1)


def max(xs: List[Int]): Int = {
  def loop(value: Int, xs: List[Int]): Int =
    if (!xs.isEmpty) {
      if (xs.head > value)
        loop(xs.head, xs.tail)
      else
        loop(value, xs.tail)
    }
    else
      value

  loop(xs.head, xs)
}

max(list)


