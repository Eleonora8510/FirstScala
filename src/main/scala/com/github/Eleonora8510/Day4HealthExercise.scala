package com.github.Eleonora8510

import scala.io.StdIn.readLine

object Day4HealthExercise extends App {
  println("Temperature exercise")
  val name = readLine("Hello! What is your name?\n")
  println(s"What is your body temperature $name?")
  val temp = readLine().toFloat
  val lowTemp = 35
  val highTemp = 37

  if (temp < lowTemp) {
    println("That is a bit too cold")
  } else if (temp >= lowTemp && temp <= highTemp) {
    println("You are all right")
  } else {
    println("You have a fever! Consider contacting a doctor")
  }

}
