import scala.collection.mutable

object Main extends App{
  val t = new Chapter5
  val time = new t.Time(2, 59)
  val time2 = new t.Time(3, 0)
  println(time.before(time2))
}
