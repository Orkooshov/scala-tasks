import scala.collection.mutable.ArrayBuffer

object Main extends App {
  val c = new Chapter12
  println(c.task8())
  val arr1 = Array("Hello", "World")
  val arr2 = Array("12345", "12345")
  c.corresponds(arr1, arr2, ())
}