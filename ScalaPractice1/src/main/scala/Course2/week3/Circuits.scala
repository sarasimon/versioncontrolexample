package Course2.week3

abstract class Circuits extends Gates {

  def halfAdder(a: Wire, b: Wire, sum: Wire, cout: Wire): Unit = {
    val d, e = new Wire
    orGate(a, b, d)
    andGate(a, b, cout)
    inverter(cout, e)
    andGate(d, e, sum)
  }

}
