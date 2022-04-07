package com.github.Eleonora8510

import scala.util.Random

object Day8StringSplitting extends App {
  println("Let's split some strings!")
  val greeting = "Welcome to Riga which is a port city. Klaipeda is also a port city"
  val food = "potatoes"
  val foodSeq = food.toCharArray
  println(foodSeq.mkString(","))
  println(food(3), foodSeq(3)) //4th letter

  val words = greeting.split(" ")
  println(words.mkString(","))
  val newGreeting = words.mkString(",")
  val wordsLengths = for (word <- words) yield word.length
  wordsLengths.foreach(println)
  for ((word, wordsLengths) <- words zip wordsLengths) {
    println((s"Word $word is $wordsLengths characters long"))
  }

  val totalCharacters = wordsLengths.sum
  val wordCount = words.length
  val averageCharacters = totalCharacters.toDouble / wordCount
  println(s"My sequence of $wordCount words has $totalCharacters for average character count io $averageCharacters")

  println(words.count(item => item.equals("port")))
  println(words.contains("Riga"))
  println(words.indexOf("Klaipeda"))
  val kIndex = words.indexOf("Klaipeda")
  println(s"Indeed we have ${words(kIndex)} as our other city")
  println(words.indexOf("Tallinn"))

  println(words.mkString(","))
  val uniqueWords = words.distinct // no duplicates
  println(uniqueWords.mkString(" "))

  val diceThrows = for (_ <- 1 to 100) yield Random.nextInt(6) + 1
  println(diceThrows.take(10) mkString (","))
}
