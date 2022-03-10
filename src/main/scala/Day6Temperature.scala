object Day6Temperature extends App {

  def fromCelsiusToFarenheit(tempCelsius: Double): Unit = {
    val tempFarenheit = 32 + Math.round((tempCelsius * 9 / 5) * 100) / 100.00
    println(tempFarenheit)
  }

  fromCelsiusToFarenheit(36.6)
  fromCelsiusToFarenheit(37)
  fromCelsiusToFarenheit(48.5)

}