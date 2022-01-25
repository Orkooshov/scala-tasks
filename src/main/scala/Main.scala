import scala.collection.mutable.ArrayBuffer
import scala.language.dynamics

object Main extends App{
  val c = new Chapter11
  val t = new c.DynamicProps(System.getProperties)
  t.java.home = "aasdf"
  println(t.java.home)
}
