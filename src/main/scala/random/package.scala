import math.pow

package object random {
  def nextInt():Int ={
    nextDouble().toInt
  }
  def nextDouble():Double ={
    (seed * 1664525 + 1013904223) % pow(2, 32)
  }

  private var seed: Int = 0
  def setSeed(seed: Int):Unit ={
    this.seed = seed
  }
}
