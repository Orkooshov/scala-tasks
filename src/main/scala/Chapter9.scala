import java.io.PrintWriter
import java.nio.charset.Charset
import java.util.Scanner
import scala.io.Source
import java.nio.file.{Files, Paths, Path}
import scala.collection.mutable.ArrayBuffer

class Chapter9 {
  // task 1
  def task1(): Unit ={
    val filename = "file9_1.txt"
    val charset = Charset.forName("UTF-8")

    val f = Source.fromFile(filename, charset.displayName)
    val buff = f.getLines().toArray
    f.close()
    val pw = new PrintWriter(filename, charset)
    buff.reverse.foreach(pw.println)
    pw.close()
  }

  // task 3
  def task3(): Unit ={
    val f = Source.fromFile("lorem.txt", "UTF-8")
    printLongWords(f)
    f.close()
  }
  def printLongWords(f: Source): Unit ={
    f.getLines().flatMap(_.split(" ")).foreach(word => {
      if (word.length >= 12) println(word)
    })
  }

  // task 4
  def task4(): Unit ={
    val sc = new Scanner(Paths.get("file9_4.txt"), "UTF-8")

    var sum = 0.0
    var (max, min) = (Double.MinValue, Double.MaxValue)
    var counter = 0

    while (sc.hasNext){
      if (sc.hasNextDouble){
        val num = sc.nextDouble
        counter += 1
        sum += num
        if (num < min) min = num
        if (num > max) max = num
      } else sc.next()
    }
    sc.close()
    val avg = sum / counter
    print(f"sum: $sum\navg: $avg\nmax: $max\nmin: $min\n")
  }
  def task4v2(): Unit ={
    val sc = new Scanner(Paths.get("file9_4.txt"), "UTF-8")
    val buff = new ArrayBuffer[Double]

    while (sc.hasNext){
      if (sc.hasNextDouble){
        buff += sc.nextDouble
      } else sc.next
    }
    sc.close()

    val (sum, max, min) = (buff.sum, buff.max, buff.min)
    val avg = sum / buff.length
    print(f"sum: $sum\navg: $avg\nmax: $max\nmin: $min\n")
  }

  // task 5
  // unclear task

  // task 6
  // todo

  // task 7
  // todo

  // task 8
  // todo

  // task 9
  def task9(): Unit ={
    val path = Paths.get("file9_9")
    println(countFiles(path, a => a.toString.endsWith(".class")))
  }
  def countFiles(path: Path, func: Path => Boolean): Int ={
    var counter = 0
    Files.walk(path).forEach(p => if (func(p)) counter += 1)
    counter
  }

  // task 10
  // todo
}
