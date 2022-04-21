package com.github.Eleonora8510

object Day19RegexExercise extends App{

  val src="src/resources/ChristieA_Poirot_Investigates.txt"
  val text = Util.getTextFromFile(src)

  val year = raw"\s\D*(\d{4})\D*\s".r

  val allYears = for (m <- year.findAllMatchIn(text)) yield m.group(1)
  allYears.foreach(println)



}
