import scala.beans.BeanProperty

class Chapter5 {
  // task 1
  class Counter {
    private var value = 0

    def increment():Unit ={
      if (value == Int.MaxValue)
        throw new Exception("Counter can't be greater than Int.MaxValue")
      value += 1
    }

    def current(): Int = value
  }

  // task 2
  class BankAccount {
    private var _balance: Double = 0

    def balance(): Double = _balance

    def deposit(sum: Double): Unit = {
      _balance += sum
    }

    def withdraw(sum: Double): Unit = {
      _balance -= sum
    }
  }

  // task 3
  class Time(private var hrs: Int, private var min: Int) {
    if (!checkHours(hrs)) {
      throw new Exception("hrs must be in between 0 and 24")
    }
    if (!checkMinutes(min)) {
      throw new Exception("min must be in between 0 and 60")
    }

    def checkHours(hours: Int): Boolean = {
      hours >= 0 && hours < 24
    }

    def checkMinutes(minutes: Int): Boolean = {
      minutes >= 0 && minutes < 60
    }

    def hours: Int = hrs

    def minutes: Int = min

    def hours_=(value: Int): Unit = {
      hrs = value
    }

    def minutes_=(value: Int): Unit = {
      min = value
    }

    def before(other: Time): Boolean = {
      if (hours < other.hours) true
      else if (hours == other.hours && minutes < other.minutes) true
      else false
    }
  }

  // task 4
  class Time2(hrs: Int, min: Int) {
    private val timeInMinutes = hrs * 60 - 1 + min

    def hours: Int = timeInMinutes / 60
    def minutes: Int = {
      val tmp = timeInMinutes % 60 + 1
      if (tmp != 60) tmp else 0
    }

    def before(other: Time2): Boolean = timeInMinutes < other.timeInMinutes
  }

  // task 5
  class Student{
    @BeanProperty var name: String = "Hello"
  }

  // task 6
  class Person(initialAge: Int) {

    private var _age: Int = if (initialAge < 0) 0 else initialAge
    def age: Int = _age
    def age_=(value: Int): Unit ={
      if (value > _age) _age = value
    }
  }

  // task 7
  class Person2(name: String){
    def firstName: String = name.split(" ")(0)
    def lastName: String = name.split(" ")(1)
  }

  // task 8
  class Car(val manufacturer: String, val model: String,
            val manufactureYear: Int = -1, var stateNumber: String = ""){
  }

  // task 9
  // ../java/Car

  // task 10
  class Employee(val name: String, var salary: Double) {
    def this() { this("John Q. Public", 0.0) }
  }
  class Employee3(val name: String = "John Q. Public", var salary: Double = 0)
}

