class Rational(x: Int, y: Int) {
  require(y != 0, "denominator  = 0")

  def this(x: Int) =
    this(x, 1)

  def numer = x
  def denom = y

  def + (r: Rational) =
    new Rational(numer * r.denom + r.numer * denom, denom * r.denom)

  def unary_- : Rational =
    new Rational(-numer, denom)

  def - (r: Rational) =
    this + -r

  override def toString =
  {
    val g = gcd(x, y)
    (numer / g).toString + '/' + (denom / g).toString
  }

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)

  def < (r: Rational) =
    numer * r.denom < denom * r.numer

  def max(r: Rational) =
    if(this < r) r else this
}

val x = new Rational(3, 9)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
x - y - z

new Rational(1)

z < y
x max y
