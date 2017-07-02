object intsets {

  val y = 2
  var x = y

}

// empty methods
abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def union(other: IntSet): IntSet = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x.<(elem)) left.contains(x)
    else if (x.>(elem)) right.contains(x)
    else true
  def incl(x: Int): IntSet =
    if (x.<(elem)) new NonEmpty(elem, left.incl(x), right)
    else if (x.>(elem)) new NonEmpty(elem, left, right.incl(x))
    else this
  def union(other: IntSet): IntSet =
    (left union right).union(other)
}