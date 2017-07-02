trait Expr
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr
case class Var(n: String) extends Expr

object exprs {
  val o_parenth : String = "("
  val c_parenth : String = ")"

  def paren(e:Expr) = {
    e match {
      case Sum(_, _) => "(" + show(e) + ")"
      case _ => show(e)
    }
  }

  def show(e: Expr): String = e match {
    case Number(x) => x.toString
    case Sum(s1,s2) => show(s1) + " + " + show(s2)
    case Prod(p1,p2) => paren(p1) + " * " + paren(p2)
    case Var(s) => s
  }
}

exprs.show(Sum(Prod(Number(2), Var("x")), Var("y")))

exprs.show(Prod(Sum(Number(2), Var("x")), Var("y")))

def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case y :: ys => insert(y, isort(ys))
}

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => x :: xs
  case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
}


def list1 : List[Int] = List(7, 2, 9, 3, 1, 10)
def list2 = isort(list1)

list1.toString()
list2.toString()

val numbers = List(5, 4, 8, 6, 2)
val sol = numbers.fold(0) { (z, i) =>
  z + i
}
