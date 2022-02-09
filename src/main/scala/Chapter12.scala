import scala.collection.mutable.ArrayBuffer

class Chapter12 {
  // task 1
  def values(fun: Int => Int, low: Int, high: Int): ArrayBuffer[(Int, Int)] ={
    val res = new ArrayBuffer[(Int, Int)]()
    for (i <- low to high){
      res += (i -> fun(i))
    }
    res
  }

  // task 2
  def task2(arr: ArrayBuffer[Int]): Int ={
    arr.reduceLeft(_ max _)
  }

  // task 3
  def factorial(n: Int): Int ={
    if (n == 0) 0
    else if (n < 1) (n to -1).reduceLeft(_ * _)
    else (1 to n).reduceLeft(_ * _)
  }

  // task 4
  // todo
  def factorial2(n: Int): Int ={
    (1 to n).foldLeft(1)((a,b) => a * b)
  }

  // task 5
  def largest(fun: Int => Int, inputs: Seq[Int]): Int ={
    inputs.map(fun).reduceLeft(_ max _)
  }

  // task 6
  def largestAt(fun: Int => Int, inputs: Seq[Int]): Int ={
    val mapped = inputs.map(fun)
    val num = mapped.reduceLeft(_ max _)
    mapped.indexOf(num) + 1
  }

  // task 7
  def task7(): Unit ={
    val pairs = (1 to 10) zip (11 to 20)
    println(pairs.map(adjustToPair(_ + _)(_)))
  }
  def adjustToPair(func: (Int, Int) => Int)(tuple: (Int, Int)): Int ={
    func(tuple._1, tuple._2)
  }

  // task 8
  def task8(): Boolean ={
    val arr1 = Array("Hello", "World")
    val arr2 = Array("12345", "12345")
    arr1.corresponds(arr2)(_.length == _.length)
  }

  // task 9
  def corresponds(seq1: Seq[String], seq2: Seq[String], p: (String, String) => Boolean): Boolean ={
    if (seq1.length != seq2.length) return false

    for ((a, b) <- seq1 zip seq2){
      if (!p(a, b)){
        return false
      }
    }
    true
  }

  // task 10
  def unless(condition: => Boolean)(block: => Unit): Unit = {
    if (!condition) block
  }
}
