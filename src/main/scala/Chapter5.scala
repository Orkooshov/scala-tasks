class Chapter5 {
  // task 1
  class Counter {
    private var value = 0
    def increment() {
      if (value == Int.MaxValue)
        throw new Exception("Counter can't be greater than Int.MaxValue")
      value += 1
    }
    def current() = value
  }

  // task 2
  class BankAccount{
    private var _balance: Double = 0
    def balance() = _balance

    def deposit(sum: Double): Unit ={
      _balance += sum
    }
    def withdraw(sum: Double): Unit ={
      _balance -= sum
    }
  }

  // task 3
  class Time(private var hrs: Int, private var min: Int){
    if (!checkHours(hrs)){
      throw new Exception("hrs must be in between 0 and 24")
    }
    if (!checkMinutes(min)){
      throw new Exception("min must be in between 0 and 60")
    }

    def checkHours(hours: Int): Boolean ={
      hours >= 0 && hours < 24
    }
    def checkMinutes(minutes: Int): Boolean ={
      minutes >= 0 && minutes < 60
    }

    def hours = hrs
    def minutes = min

    def hours_=(value: Int): Unit ={
      hrs = value
    }
    def minutes_=(value: Int): Unit ={
      min = value
    }

    def before(other: Time): Boolean ={
      if (hours < other.hours) true
      else if (hours == other.hours && minutes < other.minutes) true
      else false
    }
  }

  // task 4
  // todo

  // task 5
  // todo

  // task 6
  // todo

  // task 7

}

