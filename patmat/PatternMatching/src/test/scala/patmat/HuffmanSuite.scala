package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {

  trait TestTrees {
    val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a', 'b', 'd'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("times ") {
    new TestTrees {
      def list = List('a', 'a', 'b', 'a')
      assert(times(list).head._1 === 'b')
      assert(times(list).head._2 === 1)
      assert(times(list).tail.head._1 === 'a')
      assert(times(list).tail.head._2 === 3)
    }
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
  }

  test("singleton is true (only one leaf)") {
    assert(singleton(List(Leaf('e', 1))))
  }

  test("singleton is false") {
    assert(!singleton(List(Leaf('e', 1), Leaf('t', 2))))
  }


  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))
  }

  test("createCodeTree for a list of chars")
  {
    val fcodeTree = Fork(Fork(Leaf('t',1),Leaf('e',2),List('t', 'e'),3),Leaf('x',4),List('t', 'e', 'x'),7)
    assert(createCodeTree(List('x','x','x','e','t','e','x')) === fcodeTree)
  }

  test("print decoded secret") {
    new TestTrees {
      decodedSecret.foreach(c => println(c))
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("codeBits returns list of bits") {
    new TestTrees {
      val codeTable : CodeTable = List(('t', List(0,0)), ('e', List(0,1)), ('x', List(1)))
      assert(codeBits(codeTable)('t') === List(0,0))
    }
  }

  test("convert returns list of bits") {
    new TestTrees {
      val codeTable : CodeTable = List(('t', List(0,0)), ('e', List(0,1)), ('x', List(1)))
      val fcodeTree = Fork(Fork(Leaf('t',1),Leaf('e',2),List('t', 'e'),3),Leaf('x',4),List('t', 'e', 'x'),7)
      assert(convert(fcodeTree) === codeTable)
    }
  }

}
