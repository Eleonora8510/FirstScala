package com.github.Eleonora8510

import scala.io.StdIn.readLine

object Day15WeekdayExercise extends App{
  def getDay(day: Int): String = day match{
    case 1 => "Monday"
    case 2 => "Tuesday"
    case 3 => "Wednesday"
    case 4 => "Thursday"
    case 5 => "Friday"
    case 6 => "Saturday"
    case 7 => "Sunday"
    case _ => "Unknown weekday"
  }

  def getDayType(day: String): String = day.capitalize match{
    case "Monday" | "Tuesday" | "Wednesday" | "Tuesday" | "Friday" => "workday"
    case "Saturday" | "Sunday" => "weekend"
    case _ => "miserable day"
  }

  val weekdayNumber = readLine("Insert the number of weekday please\n").toInt
  println(getDay(weekdayNumber))

  val weekday = readLine("Insert the weekday please\n")
  println(s"It's a ${getDayType(weekday)}!")

}
