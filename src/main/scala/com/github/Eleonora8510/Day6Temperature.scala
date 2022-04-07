package com.github.Eleonora8510

object Day6Temperature extends App {

  def celsiustoFarenheit(celsius: Double): Double = 32 + celsius * 9 / 5

  def fromCelsiusToFarenheit(tempCelsius: Double): Unit = {
    val tempFarenheit = 32 + Math.round((tempCelsius * 9 / 5) * 100) / 100.00
    println(tempFarenheit)
  }

  fromCelsiusToFarenheit(36.6)
  fromCelsiusToFarenheit(37)
  fromCelsiusToFarenheit(48.5)

  println(celsiustoFarenheit(celsius = 36.6))
  println(celsiustoFarenheit(37))
  println(celsiustoFarenheit(48.5))

}
