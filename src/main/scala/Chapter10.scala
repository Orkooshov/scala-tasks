import java.awt.Point
import java.awt.geom.Ellipse2D

class Chapter10 {
  // task 1
  trait RectangleLike{
    this: Ellipse2D.Double =>
    def translate(x:Double,y:Double):Unit ={
      this.x = x
      this.y = y
    }
    def grow(x:Double,y:Double):Unit ={
      this.x += x
      this.y += y
    }
  }
  def task1(): Unit ={
    val egg = new java.awt.geom.Ellipse2D.Double(5,10,20,30)
      with RectangleLike
    egg.translate(10, -10)
    egg.grow(10, 20)
    println(egg.x)
    println(egg.y)
  }

  // task 2
  class OrderedPoint extends Point with math.Ordered[Point]{
    override def compare(that: Point): Int = {
      if (this.x < that.x || this.x == that.x || this.y < that.y) {
        0
      }
      1
    }
  }

  // task 3
  // BitSet -> SpecificIterableFactory -> Factory -> Any

  // task 4
  trait Logger{
    def log(msg: String): Unit
  }
  trait ConsoleLogger extends Logger{
    override def log(msg: String): Unit = {
      println(msg)
    }
  }
  trait CryptoLogger extends ConsoleLogger{
    var key = 3
    abstract override def log(msg: String): Unit = {
      super.log(msg.map( c => (c + key).toChar ).mkString)
    }
  }

  def task4(): Unit ={
    val l = new ConsoleLogger with CryptoLogger
    l.log("Hello")
    l.key = -3
    l.log("Hello")
  }
  // task 5
  // todo
  // task 6
  // todo
  // task 7
  // todo
  // task 8
  // todo
  // task 9
  // todo
  // task 10
  // todo

}
