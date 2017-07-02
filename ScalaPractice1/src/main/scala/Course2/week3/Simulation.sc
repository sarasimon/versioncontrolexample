package Course2.week3

object test{
  object sim extends Circuits with Parameters
  import sim._
  val in1, in2, sum, carry = new Wire


}




trait Parameters {
  def InverterDelay = 2
  def AndGateDelay = 3
  def OrGateDelay = 5
}