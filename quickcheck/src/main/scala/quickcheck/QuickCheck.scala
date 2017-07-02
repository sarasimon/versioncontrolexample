package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  lazy val genHeap: Gen[H] = for {
    n <- arbitrary[A]
    f <- arbitrary[Int]
    h <- frequency((f, empty), (10 - f, genHeap))
  } yield insert(n, h)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("min2") = forAll { (a: Int, b: Int) =>
    val h = insert(a, insert(b, empty))
    findMin(h) == (if (a < b) a else b)
  }

  property("del") = forAll { a: Int =>
    val h = insert(a, empty)
    deleteMin(h) == empty
  }

  property("seq") = forAll { (h: H) =>
    def nextElem(heap: H): Boolean = {
      if (isEmpty(deleteMin(heap))) true
      else if (findMin(heap) <= findMin(deleteMin(heap))) nextElem(deleteMin(heap))
      else false
    }
    nextElem(h)
  }

  property("mins") = forAll { (h1: H, h2: H) =>
    val m = meld(h1, h2)
    findMin(m) == findMin(h1) | findMin(m) == findMin(h2)
  }

  property("meld") = forAll { h: H =>
    val m = meld(empty, h)
    findMin(m) == findMin(h)
  }

  property("min3") = forAll { (a: Int, b: Int) =>
    val h = insert(a, insert(b, empty))
    findMin(deleteMin(h)) == (if (a < b) b else a)
  }

  property("findMin a meld heap should yield the min of the mins") = forAll { (h1: H, h2: H) =>
    findMin(meld(h1, h2)) == Math.min(findMin(h1), findMin(h2))
  }



//  property("min5") = forAll {
//    h: H =>
//      val min1 = findMin(h)
//      val min2 = if (!isEmpty(deleteMin(h))) findMin(deleteMin(h)) else findMin(h)
//      min2 >= min1
//  }
}
