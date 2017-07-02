def isPrime(n: Int) : Boolean =
  !((2 until n) map (x => n % x)).contains(0)

val prime1 = isPrime(5)

val map1 =  (1 to 10) flatMap(x => (1 to 3) map (y => (x,y)))

val n = 5
val map2 = 2 until n // 2 to n-1

def scalarProd(xs: Vector[Double], ys: Vector[Double]) =
  (xs zip ys) map{case (x,y) => x*y}