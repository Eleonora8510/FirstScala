package com.github.Eleonora8510

object Day5ForLoops extends App{
  println("Some fun with for loops")
  val myName = "Valdis"
  for (c <- myName) println(s"Give me an $c")
  //println(s"Do we have a $c")

  for (i <- 0 to 5)
    println(s"i is now $i")
  for (i <- 0 until  5) // does not include last number
    println(s"i is now $i")

var oddNumberSum = 0
  var evenNumberSum = 0
  for (n <- 0  to  50){
    if (n % 2 == 0){
      evenNumberSum += n
    } else {
      oddNumberSum += n
    }
  }

}
