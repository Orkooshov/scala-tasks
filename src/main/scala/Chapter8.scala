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
  // todo
  class Animal{

  }

  // task 4
  // task 5
  // task 6
  // task 7
  // task 8
  // task 9
  // task 10
  // task 11
  // todo
}
