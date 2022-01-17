import scala.collection.mutable
import java.awt.datatransfer._

class Chapter3 {
  def task1(num: Int):Array[Int] ={
    val arr = new Array[Int](num)
    for (i <- 0 until num){
      arr(i) = i
    }
    arr
  }
  def task2(arr: Array[Int]) ={
    for (i <- 1 until arr.length by 2){
      val t = arr(i)
      arr(i) = arr(i-1)
      arr(i-1) = t
    }
    arr
  }
  def task3(arr: Array[Int]): Array[Int] ={
    // todo
    var tmp = 0
    val res = for (i <- arr.indices if (i % 2 == 1)) yield i
    res.toArray
  }
  def task4(arr: Array[Int]): Array[Int] ={
    arr.filter(_ >= 0) ++ arr.filter(_ < 0)
  }
  def task5(arr: Array[Double]): Double ={
    var sum = 0.0
    arr.foreach(sum += _)
    sum / arr.length
  }
  def task6(arr: Array[Int]): Array[Int] ={
    arr.sorted.reverse
  }
  def task6_2(arr: mutable.Buffer[Int]): mutable.Buffer[Int] ={
    arr.sortWith(_ > _)
  }
  def task7(arr: Array[Int]): Array[Int] ={
    arr.to(mutable.LinkedHashSet).toArray
  }
  def task8(buff: mutable.Buffer[Int]): mutable.Buffer[Int] ={
//    val tmp = mutable.Buffer[Int]()
//    for (i <- buff.indices){
//      if (buff(i) < 0) tmp += i
//    }
    val tmp = (for (i <- buff.indices if (buff(i) < 0)) yield i).toBuffer
    tmp.remove(0)
    tmp.reverse.foreach(buff.remove(_))
    buff
  }
  def task10(): Array[String] ={
    val timezones = java.util.TimeZone.getAvailableIDs
    val americanTimezones = timezones.filter(_ contains "America/")
      .map(_.split('/')(1).mkString).sorted
    americanTimezones
  }
  def task11(): Unit ={
    // todo
//    val flavors = SystemFlavorMap.getDefaultFlavorMap().
//      asInstanceOf[SystemFlavorMap].getNativesForFlavors(DataFlavor.imageFlavor)
  }
}
