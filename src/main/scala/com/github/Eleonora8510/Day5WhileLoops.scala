package com.github.Eleonora8510

import scala.io.StdIn.readLine

object Day5WhileLoops extends App {
  var i = 0
  while (i < 20) {
    println("talking")
    println(s"index i $i")
    i += 1
  }
  println("")

  var sum = 0.0
  while (sum < 1000) {
    val num = readLine("Enter any number, program will quit ehn sum is over 1000.\n").toInt
    sum += num
    println(s"New sum os $sum")
  }

  var userInput = ""
  var counter = 0
  while (!userInput.toUpperCase.startsWith("Y")) {
    counter += 1
    userInput = readLine("Do you want to quit (Y/N)?")
  }

  val start = 0
  val end = 50
  val step = 4
  i = start
  while (i < end) {
    println(s"Doing something i is $i")
    i += step
  }
  println(s"We are done with whike loops i is $i")
}
