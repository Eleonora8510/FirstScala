package com.github.Eleonora8510

import scala.util.Random

object Day4PatternMatchingIntro extends App{
  println("Short introduction to pattern matching")
  //https://docs.scala-lang.org/tour/pattern-matching.html

  val x: Int = Random.nextInt(10)

  val txt = x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }

  println(s"So $x -> $txt")
}

//////  match {
//  println(s"What is your body temperature $name?")
//  val temp = readLine().toFloat
//    case (temp < 35) => println("That is a bit too cold")
//    case (temp >= 35 && temp <= 37 ) => println("You are all right")
//    case (temp > 35) => println("You have a fever! Consider contacting a doctor")