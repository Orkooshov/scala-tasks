import scala.collection.{mutable, immutable}

class Chapter8 {
  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance
    def currentBalance: Double = balance
    def deposit(amount: Double): Double ={ balance += amount; balance }
    def withdraw(amount: Double): Double ={ balance -= amount; balance }
  }

  // task 1
  class CheckingAccount(initialBalance: Double, var commission: Double = 1)
    extends BankAccount(initialBalance){

    override def deposit(amount: Double): Double = {
      super.deposit(amount)
      super.withdraw(commission)
    }
    override def withdraw(amount: Double): Double = {
      super.withdraw(amount)
      super.withdraw(commission)
    }
  }

  // task 2
  class SavingsAccount(initialBalance: Double = 0,
                       var commission: Double = 1,
                       initialFreeTransactionsQuantity: Int = 3)
    extends BankAccount(initialBalance){

    var freeTransactionsQuantity: Int = initialFreeTransactionsQuantity
    def isFreeTransactionAvailable: Boolean = freeTransactionsQuantity > 0
    def operationCommitted(): Unit ={
      if (isFreeTransactionAvailable)
        freeTransactionsQuantity -= 1
    }

    def withdrawCommission(): Unit ={
      if (!isFreeTransactionAvailable) super.withdraw(commission)
      else operationCommitted()
    }

    override def deposit(amount: Double): Double ={
      super.deposit(amount)
      withdrawCommission()
      currentBalance
    }

    override def withdraw(amount: Double): Double ={
      super.withdraw(amount)
      withdrawCommission()
      currentBalance
    }
    def earnMonthlyInterest(percents: Double): Unit ={
      freeTransactionsQuantity = initialFreeTransactionsQuantity
      val earnSum: Double = currentBalance / 100 * percents
      deposit(earnSum)
    }
  }

  // task 3
  class Car(val model: String, val maxSpeed: Int, val yearOfManufacture: Int){
    def gas(): Unit ={
    }
    def brake(): Unit ={
    }
  }
  class Truck(model: String, maxSpeed: Int, yearOfManufacture: Int, val capacity: Double)
    extends Car(model, maxSpeed, yearOfManufacture){
    def load(): Unit ={
    }
    def unload(): Unit ={
    }
  }
  class Sedan(model: String, maxSpeed: Int, yearOfManufacture: Int)
    extends Car(model, maxSpeed, yearOfManufacture)

  // task 4
  abstract class Item{
    def price: Double
    def description: String
  }
  class SimpleItem(override val price: Double, override val description: String)
    extends Item{

  }
  class Bundle(items: mutable.ArrayBuffer[SimpleItem], val description: String){
    def price: Double ={
      var sum = 0.0
      items.foreach(sum += _.price)
      sum
    }
    def addItems(once: IterableOnce[SimpleItem]): Unit ={
      items ++= once
    }
  }

  // task 5
  class Point(x: Double, y: Double){
  }
  class LabeledPoint(label: String, x: Double, y: Double) extends Point(x, y)

  // task 6
  abstract class Shape{
    def centerPoint: Point
  }
  class Rectangle(val centerPoint: Point) extends Shape
  class Circle(val centerPoint: Point) extends Shape

  // task 7
  class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width){
    def this(){
      this(0, 0, 0)
    }
    def this(width: Int){
      this(0, 0, width)
    }
  }

  // task 9
  class Creature {
    def range: Int = 10
    println(f"Creature#range: $range")
    val env: Array[Int] = new Array[Int](range)
    println(f"Creature#env.length: ${env.length}%n")
  }
  class Ant extends Creature {
    println(f"Ant#range (before): $range")
    println(f"Ant#env.length (before): ${env.length}")
    override def range = 2
    println(f"Ant#range (after): $range")
    println(f"Ant#env.length (after): ${env.length}")
  }

}

// task 11
class Point(val n: Long) extends AnyVal {
  override def toString: String = f"$n"
}
object Point{
  def apply(x: Int, y: Int): Point ={
    new Point(x * y)
  }
}
