package com.github.Eleonora8510

import java.time.Year
import scala.io.StdIn.readLine

object Day3AgeCalculator extends App {
  val myName = readLine("What is your name?")
  println(s"Nice to meet you, $myName!")
  val myAge = readLine(s"How old are you, $myName?").toInt
  val diff = 100 - myAge
  //println(diff)
  val year = Year.now.getValue
  val newYear = year + diff
  //println(year)
  //println(newYear)
  //println(year.getClass, diff.getClass, newYear.getClass)
  println(s"So, at $newYear you will be 100 years old ;)")
}
