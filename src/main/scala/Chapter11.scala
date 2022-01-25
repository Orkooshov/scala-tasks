import scala.language.dynamics
import scala.collection.mutable.ArrayBuffer
import java.nio.file.Path

class Chapter11 {
  def task1(): Unit ={
    println(3 + 4 -> 5)
    println(3 -> (4 + 5))
  }

  // task 3
  class Fraction(n: Int, d: Int) {
    private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
    private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)
    override def toString: String = num + "/" + den
    def sign(a: Int): Int = if (a > 0) 1 else if (a < 0) -1 else 0
    def gcd(a: Int, b: Int): Int = if (b == 0) math.abs(a) else gcd(b, a % b)

    def +(other: Fraction): Fraction ={
      // a/b + c/d = (ad+bc)/bd
      val numFirst = num * other.den
      val numSecond = den * other.num
      new Fraction(numFirst + numSecond, den * other.den)
    }
    def -(other: Fraction): Fraction ={
      this + new Fraction(-other.num, other.den)
    }
    def *(other: Fraction): Fraction ={
      new Fraction(num * other.num, den * other.den)
    }
    def /(other: Fraction): Fraction ={
      val swapped = new Fraction(other.den, other.num)
      this * swapped
    }
  }

  // task 4
  class Money(n: Int, d: Int){
    private def d_Ok(d: Int): Boolean = d >= 0 && d < 100

    val num: Int = {
      if (d_Ok(d)) n
      else n + Math.floorDiv(d, 100)
    }
    val den: Int = {
      if (d_Ok(d)) d
      else Math.floorMod(d, 100)
    }

    def +(other: Money): Money ={
      new Money(num+other.num, den+other.den)
    }
    def -(other: Money): Money ={
      new Money(num-other.num, den-other.den)
    }
    override def toString: String ={
      f"$num.$den"
    }
  }

  // task 5
  // todo
  class Table(val html: String){
    def |(node: String): Table ={
      new Table("")
    }
    def ||(node: String): Table ={
      new Table("")
    }

    override def toString: String = html
  }
  object Table{
    def apply(): Table = new Table("<table></table>")
  }

  // task 6
  // todo

  // task 7
  class BitSequence(sequence: ArrayBuffer[Long]) {
    val seq: ArrayBuffer[Long] = sequence
    def apply(index: Int): Long = seq(index)
    def update(index: Int, newValue: Long): Unit ={
      seq(index) = newValue
    }
  }

  // task 8
  // todo

  // task 9 - 10
  class RichFile(val path: String){
  }
  object RichFile{
    def apply(path: String): RichFile = new RichFile(path)
    def unapply(input: RichFile): Option[(String, String, String)] ={
      val p = Path.of(input.path)
      val fileDirectory = p.getParent.toString
      val s = p.getFileName.toString
      val fileBaseName = s.substring(0, s.lastIndexOf("."))
      val fileExtension = s.substring( s.lastIndexOf(".")+1, s.length )
      Some((fileDirectory, fileBaseName, fileExtension))
    }
    def unapplySeq(input: RichFile): Option[Seq[String]] ={
      var p = Path.of(input.path)
      val res = new ArrayBuffer[String]
      while (p.getFileName != null){
        res += p.getFileName.toString
        p = p.getParent
      }
      Some(res.reverse.toSeq)
    }
  }

  // task 11
  class DynamicPropsNode(val props: java.util.Properties, val partialPath: String)
    extends Dynamic {
    def updateDynamic(name: String)(value: String): Unit ={
      props.setProperty(f"$partialPath.$name", value)
    }
    def selectDynamic(name: String): String = {
      props.getProperty(f"$partialPath.$name")
    }
  }
  class DynamicProps(val props: java.util.Properties) extends Dynamic {
    def updateDynamic(name: String)(value: String): Unit ={
      props.setProperty(name, value)
    }
    def selectDynamic(name: String): DynamicPropsNode = {
      new DynamicPropsNode(props, name)
    }
  }

  // task 12
  // todo
  // task 13
  // todo
}
