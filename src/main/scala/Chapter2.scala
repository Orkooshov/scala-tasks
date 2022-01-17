import scala.io.StdIn

class Chapter2 {
  def task1(x: Double):Int ={
    if (x > 0) 1
    else if (x < 0) -1
    else 0
  }
  def task4() ={
    for (i <- 10 to 0 by -1){
      println(i)
    }
  }
  def task5(n: Int): Unit ={
    (0 to n).reverse.foreach(println)
    // (0 to n).reverse.foreach(println(_))
  }
  def task6(s: String): Unit ={
    var res = BigInt(1)
    for (i <- s){
      res *= i.toInt
    }
    println(res)
  }
  def task7(s: String): Unit ={
    var res = BigInt(1)
    s.foreach(res *= _.toInt)
    println(res)
  }
  def task8(s: String): BigInt ={
    var res = BigInt(1)
    s.foreach(res *= _.toInt)
    res
  }
  def task9(s: String, n: BigInt = 1): BigInt ={
    if (s.length > 1) task9(s.substring(1), n*s.charAt(0).toInt)
    else s.charAt(0).toInt * n
  }
  def task10(x: Double, n: Int): Double ={
    0
  }
}
