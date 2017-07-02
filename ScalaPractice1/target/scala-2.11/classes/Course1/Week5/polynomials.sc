class Poly(terms0: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) =
    this(bindings.toMap)

  val terms = terms0 withDefaultValue 0.0

  def +(other: Poly)  =
    new Poly(
      (other.terms foldLeft this.terms)(addTerm)
    )

  def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
    val (exp, coeff) = term
    terms + (exp -> (coeff + terms(exp)))
  }

  override def toString: String =
    (for ((exp, coeff) <- terms.toList.sorted.reverse)
      yield coeff + "x^" + exp) mkString (" + ")

}

val p1 = new Poly(0 -> 3.0, 3 -> 7.0)
val p2 = new Poly(Map(0 -> 1.0, 2 -> 2.1, 3 -> 1.0))

val p3 = p1 + p2