import scala.collection.mutable

class Chapter13 {
  // task 1
  def task1(): Unit ={
    println(indexes("Mississippi"))
    println(indexes2("Mississippi"))
  }
  def indexes(s: String, c: Char): mutable.SortedSet[Int] ={
    val set = mutable.SortedSet.empty[Int]
    for ((ch, i) <- s.zipWithIndex) {
      if (c == ch) set += i
    }
    set
  }
  def indexes2(s: String): mutable.HashMap[Char, mutable.SortedSet[Int]] ={
    val t = new mutable.HashMap[Char, mutable.SortedSet[Int]]
    s.toSet.foreach((c: Char) => {
      val set = indexes(s, c)
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

}
