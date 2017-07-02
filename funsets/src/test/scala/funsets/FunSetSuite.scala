package funsets

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
  * This class is a test suite for the methods in object FunSets. To run
  * the test suite, you can either:
  *  - run the "test" command in the SBT console
  *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
  */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
    * Link to the scaladoc - very clear and detailed tutorial of FunSuite
    *
    * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
    *
    * Operators
    *  - test
    *  - ignore
    *  - pending
    */

  /**
    * Tests are written using the "test" operator and the "assert" method.
    */
  // test("string take") {
  //   val message = "hello, world"
  //   assert(message.take(5) == "hello")
  // }

  /**
    * For ScalaTest tests, there exists a special equality operator "===" that
    * can be used inside "assert". If the assertion fails, the two values will
    * be printed in the error message. Otherwise, when using "==", the test
    * error message will only say "assertion failed", without showing the values.
    *
    * Try it out! Change the values so that the assertion fails, and look at the
    * error message.
    */
  // test("adding ints") {
  //   assert(1 + 2 === 3)
  // }


  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
    * When writing tests, one would often like to re-use certain values for multiple
    * tests. For instance, we would like to create an Int-set and have multiple test
    * about it.
    *
    * Instead of copy-pasting the code for creating the set into every test, we can
    * store it in the test class using a val:
    *
    * val s1 = singletonSet(1)
    *
    * However, what happens if the method "singletonSet" has a bug and crashes? Then
    * the test methods are not even executed, because creating an instance of the
    * test class fails!
    *
    * Therefore, we put the shared values into a separate trait (traits are like
    * abstract classes), and create an instance inside each test method.
    *
    */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  /**
    * This test is currently disabled (by using "ignore") because the method
    * "singletonSet" is not yet implemented and the test would fail.
    *
    * Once you finish your implementation of "singletonSet", exchange the
    * function "ignore" by "test".
    */
  test("singletonSet(1) contains 1") {

    /**
      * We create a new instance of the "TestSets" trait, this gives us access
      * to the values "s1" to "s3".
      */
    new TestSets {
      /**
        * The string argument of "assert" is a message that is printed in case
        * the test fails. This helps identifying which assertion failed.
        */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("set with numbers 1 to 100") {
    new TestSets {
      val set1to100: Set = elem => 1 < elem && 100 > elem
      assert(contains(set1to100, 99), "Union 1")
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect contains only the elements which are in both sets") {
    new TestSets {
      val s = intersect(union(s1, s2), s1)
      assert(contains(s, 1), "Intersection 1")
      assert(!contains(s, 2), "No intersection 2")
    }
  }

  test("difference contains the elements which are only in the first set and not in the second") {
    new TestSets {
      val s = diff(union(s1, s2), s1)
      assert(!contains(s, 1), "No difference 1")
      assert(contains(s, 2), "Difference 2")
    }
  }

  test("filter contains de elements of the set (1,2,3) that satisfy < 3") {
    new TestSets {
      val s = union(s3, union(s1, s2))
      // = (1,2,3)
      val f = filter(s, x => x < 3)
      assert(contains(f, 1), "Condition 1 < 3")
      assert(contains(f, 2), "Condition 2 < 3")
      assert(!contains(f, 3), "Condition 3 is not < 3")
    }
  }

  test("filter contains de elements of the set (1,2,3) that satisfy > 2") {
    new TestSets {
      val s = union(s3, union(s1, s2))
      // = (1,2,3)
      val f = filter(s, x => x > 2)
      assert(!contains(f, 1), "Condition 1 is not > 2")
      assert(!contains(f, 2), "Condition 2 is not > 2")
      assert(contains(f, 3), "Condition 3 > 2")
    }
  }

  test("forall is true when all the numbers in set satisfy < 4") {
    new TestSets {
      val s = union(s3, union(s1, s2))
      // = (1,2,3)
      val forallLessThan4 = forall(s, x => x < 4)
      assert(forallLessThan4)
    }
  }

  test("forall is false when all the numbers in set satisfy > 2") {
    new TestSets {
      val s = union(s3, union(s1, s2))
      // = (1,2,3)
      val forallBiggerThan2 = forall(s, x => x > 2)
      assert(!forallBiggerThan2)
    }
  }

  test("exists is true when at least a number satisfies > 2") {
    new TestSets {
      val s = union(s3, union(s1, s2))
      // = (1,2,3)
      val existsBiggerThan2 = exists(s, x => x > 2)
      assert(existsBiggerThan2)
    }
  }

  test("exists is false when at least a number satisfies < 0") {
    new TestSets {
      val s = union(s3, union(s1, s2))
      // = (1,2,3)
      val existsLessThan0 = exists(s, x => x < 0)
      assert(!existsLessThan0)
    }
  }

  test("map maps all the elements of the set of numbers from 1 to 100 into negatives") {
    new TestSets {
      val set1to100: Set = elem => 0 < elem && 100 > elem
      val negatives = map(set1to100, x => -x)
      assert(forall(negatives, x => x < 0))
    }
  }

  test("map maps all the elements of the set of numbers from 1 to 100 into multiples of 3") {
    new TestSets {
      val set1to100: Set = elem => 0 < elem && 100 > elem
      val multiplesOf3 = map(set1to100, x => x*3)
      assert(forall(multiplesOf3, x => x%3 == 0))
    }
  }
}
