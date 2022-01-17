import scala.collection.mutable
import scala.collection.immutable
import java.util
import scala.io.Source
import scala.jdk.CollectionConverters._

class Chapter4 {
  def task1(): Unit ={
    val goods = Map[String, Double]("book" -> 1000, "copybook" -> 500)
    val goodsDiscount = for ((k, v) <- goods) yield (k, v / 100 * 90)
    println(goodsDiscount)
  }
  def task2(): Unit ={
    val fileSource = Source.fromFile("file4_2.txt", enc = "UTF-8")
    val words = new mutable.HashMap[String, Int]()
    fileSource.getLines().flatMap(_.split(" ")).foreach(word => {
      if (words.contains(word)) words(word) += 1
      else words += word -> 1
    })
    fileSource.close()
//    fileSource.getLines().foreach(line => {
//      line.split(" ").foreach(w => {
//        if (words.contains(w)) words(w) += 1
//        else words += w -> 1
//      })
//    })
    words.foreach(println(_))
  }
  def task3(): Unit ={
    val fileSource = Source.fromFile("file4_2.txt", enc = "UTF-8")
    var words = new immutable.HashMap[String, Int]()
    fileSource.getLines().flatMap(_.split(" ")).foreach(word => {
      if (words.contains(word)) {
        val t = (word, words(word)+1)
        words = words.removed(word) + t
      }
      else words = words + (word -> 1)
    })
    fileSource.close()
    words.foreach(println)
  }
  def task4(): Unit ={
    val fileSource = Source.fromFile("file4_2.txt", enc = "UTF-8")
    var words = new immutable.TreeMap[String, Int]()
    fileSource.getLines().flatMap(_.split(" ")).foreach(word => {
      if (words.contains(word)) {
        val t = (word, words(word)+1)
        words = words.removed(word) + t
      }
      else words = words + (word -> 1)
    })
    fileSource.close()
    words.foreach(println)
  }
  def task5(): Unit ={
    val file = new java.io.File("file4_2.txt")
    val scanner = new util.Scanner(file, "UTF-8")
    val words = new util.TreeMap[String, Int]().asScala
    while (scanner.hasNext()){
      val word = scanner.next()
      if (words.contains(word)) words(word) = words(word) + 1
      else words += (word -> 1)
    }
    words.foreach(println)
  }
  def task6(): Unit ={
    // todo
    val lhs = new mutable.LinkedHashSet[String]
  }
  def task7(): Unit ={
    // todo
  }
  def task8(values: Array[Int]): (Int, Int) ={
    (values.min, values.max)
  }
  def task9(values: Array[Int], v: Int): (Int, Int, Int) ={
    var lt, eq, gt = 0
    values.foreach(x => {
      if (x > v) gt += 1
      else if (x < v) lt += 1
      else eq += 1
    })
    (lt, eq, gt)
  }
  def task10(): Unit ={
    println("Hello".zip("World"))
  }
}
