import data.Data.books

//books.groupBy(book => book.author)
//        .mapValues()


Map("a" -> 1, "b" -> 2)
Map(("a",1), ("b",2))

// varargs * = means indefinite number of args
def m(ps: Int*) : Seq[Int] = ps

val xs = List(1,2,3,4)
m(1,2,3,4) == m(xs: _*)
