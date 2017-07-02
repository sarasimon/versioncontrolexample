val xs = List(1,2,3)
val ys = List("a","b")

xs.flatMap{case x => ys.map { case y => x -> y}}

