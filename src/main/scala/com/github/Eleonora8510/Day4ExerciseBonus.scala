package com.github.Eleonora8510

import scala.io.StdIn.readLine

object Day4ExerciseBonus extends App {
  println("Xmas bonus calculator")
  val persName = readLine("Hello! What is your name?")
  val persWorkExper = readLine(s"How long have you been working in the firm, $persName?").toInt
  val persWage = readLine("What was your monthly wage?").toDouble
  if (persWorkExper >= 2) {
    val bonus = persWage * 0.15 * (persWorkExper - 2)
    println(s"$persName, great! Your Christmas bonus is $bonus")
  } else println("Sorry, you have no Christmas bonus.")
}