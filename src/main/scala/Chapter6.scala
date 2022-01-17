class Chapter6 {
  // task 1
  object Conversions{
    def inchesToCentimeters(inches: Double): Double ={
      inches * 2.54
    }
    def gallonsToLiters(gallons: Double): Double ={
      gallons * 3.785412
    }
    def milesToKilometers(miles: Double): Double ={
      miles * 1.609344
    }
  }

  // task 2
  object UnitConversion{
    object InchesToCentimeters{
      def apply(inches: Double): Double ={
        inches * 2.54
      }
    }
  }

  // task 3
  object Origin extends java.awt.Point

  // task 4
  class Point(var x: Double, var y: Double)
  object Point{
    def apply(x: Double, y: Double): Point ={
      new Point(x, y)
    }
  }

  // task 5
  //  object Main extends App{
  //    println(args.reverse.mkString(" "))
  //  }

  // task 6
  object CardSuit extends Enumeration{
    type CardSuit = Value
    val Club = Value("♣")
    val Diamond = Value("♦")
    val Heart = Value("♥")
    val Spade = Value("♠")
  }

  // task 7
  def cardColor(cs: CardSuit.CardSuit): String ={
    if (cs == CardSuit.Heart || cs == CardSuit.Diamond) "red"
    else "black"
  }

  // task 8
  object Color extends Enumeration{
    type Color = Value
    val red = Value(0xff0000)
    val green = Value(0x00ff00)
    val blue = Value(0x0000ff)
  }
  object CubeCorner extends Enumeration{
    type CubeCornersColors = Value
    val first, fourth, eighth = Value(Color.red.id)
    val second, fifth = Value(Color.green.id)
    val third, sixth = Value(Color.blue.id)
  }
}