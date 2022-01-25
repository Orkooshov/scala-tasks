package com
package horstmann
package impatient

object Test2 {
  override def toString: String = "com.horstmann.impatient.Test2"
  def impatient(): Boolean ={
    try{
      Test3.toString
      true
    }
    catch {
      case _: Exception => false
    }
  }
}
