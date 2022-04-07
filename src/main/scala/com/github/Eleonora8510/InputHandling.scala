package com.github.Eleonora8510

import scala.io.StdIn.readLine

object InputHandling extends App{
  val myName = readLine("What os your name?")
  println(s"Cool your name is $myName, isn't is?")
  val potatoCount = readLine ("How many kg of potatoes do you have?")
  println(s"Cool, you have $potatoCount kg ")
  val cost = 0.78
  val total = potatoCount.toDouble * cost
  val rounded = Math.round(total * 100) / 100.0
  println(s"Without rounding $total")
  println(s"So those must cost $rounded Euros")

}
