package com.horstmann.impatient

object Test {
  override def toString: String = "com.horstmann.impatient.Test"

  def impatient(): Boolean ={
    try{
      // Test3.toString
      // Test3 недоступен
      true
    }
    catch {
      case _: Exception => false
    }
  }
}
