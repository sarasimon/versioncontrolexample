val xs = List(1,2,3,4)
sum(xs)
multiply(xs)

def sum(xs: List[Int]): Int = {
  foldLeft(xs, 0)((acc,elem) => acc + elem)
}

def multiply(xs: List[Int]): Int = {
  foldLeft(xs, 1)((acc,elem) => acc * elem)
}

// abstracts the iteration process
// two different parameters lists doesn't need to be parameterised
def foldLeft[Result](xs: List[Int], seed: Result)(f: (Result,Int) => Result): Result = {
  val it = xs.iterator
  var result : Result = seed

  while(it.hasNext){
    result = f(result, it.next())
    println("current value is:" + result)
  }

  result
}


xs map (_ + 1)

def add(a: Int, b: Int) = a + b

