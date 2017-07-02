package objsets

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TweetSetSuite extends FunSuite {
  trait TestSets {
    val set1 = new Empty
    val set2 = set1.incl(new Tweet("a", "a body", 20))
    val set3 = set2.incl(new Tweet("b", "b body", 20))
    val c = new Tweet("c", "c body", 7)
    val d = new Tweet("d", "d body", 9)
    val set4c = set3.incl(c)
    val set4d = set3.incl(d)
    val set5 = set4c.incl(d)

    val set1a = set1.incl(new Tweet("a", "a body", 19))
    val set1b = set1a.incl(new Tweet("b", "b body", 20))
    val set1c = set1b.incl(new Tweet("c", "c body", 22))
  }

  def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }

  def size(set: TweetSet): Int = asSet(set).size

  def listSize(tweets: TweetList): Int = {
    var count = 0
    tweets.foreach(tw => count += 1)
    count
  }

  test("filter: on empty set") {
    new TestSets {
      assert(size(set1.filter(tw => tw.user == "a")) === 0)
    }
  }

  test("filter: a on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.user == "a")) === 1)
    }
  }

  test("filter: 20 on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.retweets == 20)) === 2)
    }
  }

  test("filter: c on set4d") {
    new TestSets {
      assert(size(set4d.filter(tw => tw.user == "c")) === 0)
    }
  }

  test("union: set4c and set4d") {
    new TestSets {
      assert(size(set4c.union(set4d)) === 4)
    }
  }

  test("union: set4d and set4c") {
    new TestSets {
      assert(size(set4d.union(set4c)) === 4)
    }
  }

  test("union: set3 and set4c") {
    new TestSets {
      assert(size(set3.union(set4c)) === 3)
    }
  }

  test("union: with empty set (1)") {
    new TestSets {
      assert(size(set5.union(set1)) === 4)
    }
  }

  test("union: with empty set (2)") {
    new TestSets {
      assert(size(set1.union(set5)) === 4)
    }
  }

  test("mostRetweetedTweet: set5") {
    new TestSets {
      val mostRetweetedTweet = set5.mostRetweeted
      assert(mostRetweetedTweet.user == "a")
    }
  }

  test("mostRetweetedTweet: set1c") {
    new TestSets {
      val mostRetweetedTweet = set1c.mostRetweeted
      assert(mostRetweetedTweet.user == "c")
    }
  }

  test("descending: set5") {
    new TestSets {
      val trends = set5.descendingByRetweet
      assert(!trends.isEmpty)
      assert(trends.head.user == "a" || trends.head.user == "b")
    }
  }

  test("descending: set1c") {
    new TestSets {
      val trends = set1c.descendingByRetweet
      assert(!trends.isEmpty)
      assert(trends.head.user == "c")
    }
  }

  test("google and apple tweet sets") {
    new TestSets {
      assert(size(GoogleVsApple.appleTweets) > 0)
      assert(size(GoogleVsApple.googleTweets) > 0)
    }
  }

  test("google and apple trends") {
    new TestSets {
      assert(listSize(GoogleVsApple.trending) == size(GoogleVsApple.googleAndAppleTweets))
      GoogleVsApple.trending.foreach(t => print(t.text))
    }
  }

  }
