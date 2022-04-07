package com.github.Eleonora8510

// application without extends
object Day14noApp {
  // in order to run application you need to define main
  def toInt(s: String): Int = {
    try {
      s.toInt
    } catch {
      case e: Exception => 0
    }
  }

  def toDouble(s: String): Double = {
    try {
      s.toDouble
    } catch {
      case e: Exception => 0
    }
  }
  var myResult = 0

  def main(args:Array[String]):Unit={
    println("Starting main function")
    for (arg <- args){
      println(s"Going to do something with argument: $arg type is ${arg.getClass}")
    }
    myResult += args(2).toInt
    println(myResult)
    myResult += toInt(args(0))
    println(myResult)
    myResult += toDouble(args(1)).toInt
    println(myResult)
    println("All done")
  }

}
