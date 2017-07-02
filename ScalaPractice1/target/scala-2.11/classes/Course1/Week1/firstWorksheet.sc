"Hello world"
1
1.0

def sqrt(x: Double) =
{
  def sqrtIteration(guess: Double): Double =
    if (isGoodEnough(guess))
      guess
    else
      sqrtIteration(improve(guess))

  def isGoodEnough(guess: Double) =
    Math.abs(guess * guess - x) < 0.01*x

  def improve(guess: Double) =
    (guess + x/guess) / 2

  sqrtIteration(1.0)
}

sqrt(2)
sqrt(3)
sqrt(4)
sqrt(1e50)
sqrt(1.0e20)

def gcd(a: Int, b: Int) : Int =
  if (a == 0)
    b
  else
    gcd(b % a, a)

gcd(14,21)
gcd(9,11)

def factorial(n : Int) =
{
  def loop(acc : Int, n: Int) : Int=
    if (n == 0)
      acc
    else
      loop(acc*n,n-1)

  loop(1,n)
}

factorial(4)




