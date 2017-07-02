package Course1.scala

//abstract class Boolean {
//  def ifThenElse[T](t: => T, e: => T): T
//
//  def &&(x: => Boolean): Boolean = ifThenElse(x, ifalse)
//
//  def ||(x: => Boolean): Boolean = ifThenElse(ifalse, x)
//
//  def unary_! : Boolean = ifThenElse(ifalse, itrue)
//
//  def ==(x: Boolean): Boolean = ifThenElse(x, x.unary_!)
//
//  def !=(x: Boolean): Boolean = ifThenElse(x.unary_!, x)
//
//}

abstract class Nat {
  def isZero: Boolean

  def predecessor: Nat

  def successor: Nat = new Succ(this)

  def +(that: Nat): Nat

  def -(that: Nat): Nat
}

object Zero extends Nat {
  def isZero: Boolean = true

  override def predecessor: Nat = throw new NumberFormatException

  def +(that: Nat): Nat = that

  def -(that: Nat): Nat = if(that.isZero) this else throw new NumberFormatException
}

class Succ(n: Nat) extends Nat {
  override def isZero: Boolean = false

  def predecessor: Nat = n

  override def +(that: Nat): Nat = new Succ(n + that)

  override def -(that: Nat): Nat = if(that.isZero) this else n - that.predecessor
}


