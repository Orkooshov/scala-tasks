import scala.collection.mutable.ArrayBuffer


object Sudoku {
  /*
  * Константа для размера судоку
   */
  val SIZE = 9

  /*
  * Проверка размера массива (размер сравнивается с константой SIZE)
   */
  def checkSize(sudoku: Array[Array[Int]]): Boolean = {
    var isCorrect = true
    // проверка количества столбцов
    if (sudoku.length != SIZE) isCorrect = false
    // проверка количества строк
    sudoku.foreach(row => {
      if (row.length != SIZE) isCorrect = false
    })
    isCorrect
  }

  /*
  * Проверка уникальности и диапазона чисел
   */
  def checkNumbers(nums: Array[Int]): Boolean = {
    val availableNums = (1 to SIZE).toBuffer
    var isCorrect = true
    nums.foreach(num => {
      if (availableNums.contains(num)) availableNums -= num
      else isCorrect = false
    })
    isCorrect
  }

  /*
  * Проверка всех строк
   */
  def checkRows(sudoku: Array[Array[Int]]): Boolean = {
    sudoku.forall(checkNumbers)
  }

  /*
  * Проверка всех столбцов
   */
  def checkColumns(sudoku: Array[Array[Int]]): Boolean = {
    for (i <- 0 until SIZE) {
      if (!checkNumbers(sudoku.map(_ (i)))) return false
    }
    true
  }

  /*
  * Проверка блоков (если размер судоку 9х9, то размер блока - 3х3)
   */
  def checkBlocks(sudoku: Array[Array[Int]]): Boolean = {
    val blockSize = math.sqrt(SIZE).toInt
    var rowOffset, columnOffset = 0
    for (counter <- 0 until SIZE) {
      val block = new ArrayBuffer[Int](SIZE)
      for (i <- rowOffset until rowOffset + blockSize) {
        for (j <- columnOffset until columnOffset + blockSize) {
          block += sudoku(i)(j)
        }
      }
      if (!checkNumbers(block.toArray)) return false
      rowOffset += blockSize
      if (rowOffset >= SIZE) {
        rowOffset = 0
        columnOffset += blockSize
      }
    }
    true
  }

  /*
  * Метод, проверяющий корректность решения Судоку
   */
  def checkSudoku(sudoku: Array[Array[Int]]): Boolean = {
    if (!checkSize(sudoku)) false
    else if (!checkRows(sudoku)) false
    else if (!checkColumns(sudoku)) false
    else if (!checkBlocks(sudoku)) false
    else true
  }

  def testCheckSudoku(): Unit ={
    val arr = Array(
      Array(2, 9, 3, 4, 5, 7, 6, 8, 1),
      Array(4, 7, 5, 1, 8, 6, 3, 9, 2),
      Array(1, 6, 8, 3, 9, 2, 7, 4, 5),
      Array(9, 4, 2, 5, 7, 1, 8, 6, 3),
      Array(3, 8, 1, 6, 2, 9, 5, 7, 4),
      Array(6, 5, 7, 8, 3, 4, 1, 2, 9),
      Array(7, 2, 6, 9, 1, 3, 4, 5, 8),
      Array(5, 1, 4, 2, 6, 8, 9, 3, 7),
      Array(8, 3, 9, 7, 4, 5, 2, 1, 6),
    )
    println(if (Sudoku.checkSudoku(arr)) "корректно" else "некорректно")
  }
}
