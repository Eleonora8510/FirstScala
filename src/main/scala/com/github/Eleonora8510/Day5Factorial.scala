package com.github.Eleonora8510

import scala.io.StdIn.readLine

object Day5Factorial extends App {
  println("Calculating Factorial")
  val number = readLine("What positive integer you want yp know Factorial for?").toInt
  println(s"Calculating Factorial foe numbber $number")
  var result = 1
  for (n <- 2 to number) result *= n
  println(s"Fact of $number is $result")
}
