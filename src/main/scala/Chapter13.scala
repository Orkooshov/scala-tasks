import scala.collection.mutable
import scala.collection.immutable

class Chapter13 {
  // task 1
  def task1(): Unit ={
    println(indexes("Mississippi"))
    println(indexesV2("Mississippi"))
  }
  def indexesByChar(s: String, c: Char): mutable.SortedSet[Int] ={
    val set = mutable.SortedSet.empty[Int]
    for ((ch, i) <- s.zipWithIndex) {
      if (c == ch) set += i
    }
    set
  }
  def indexesV2(s: String): mutable.HashMap[Char, mutable.SortedSet[Int]] ={
    val t = new mutable.HashMap[Char, mutable.SortedSet[Int]]
    s.toSet.foreach((c: Char) => {
      val set = indexesByChar(s, c)
      t += (c -> set)
    })
    t
  }
  def indexes(s: String): mutable.HashMap[Char, mutable.SortedSet[Int]] ={
    val t = new mutable.HashMap[Char, mutable.SortedSet[Int]]
    for ((c, i) <- s.view.zipWithIndex) {
      if (!t.keys.toSeq.contains(c)){
        t += (c -> mutable.SortedSet.empty)
      }
      t(c) += i
    }
    t
  }

  // task 2
  def task2(): Unit ={
    println(indexes("Mississippi"))
    println(indexes2("Mississippi"))
  }
  def indexes2(s: String): immutable.HashMap[Char, List[Int]] ={
    var t = new immutable.HashMap[Char, List[Int]]
    for ((c, i) <- s.view.zipWithIndex) {
      if (!t.keys.toSeq.contains(c)) {
        t = t + (c -> List(i))
      } else{
        t = t.removed(c) + (c -> (i :: t(c)))
      }
    }
    t
  }
}
