package com.github.Eleonora8510

import scala.io.StdIn.readLine

object Day9WordLengthExercise extends App {
  //TODO ask user to enter a sentence
  //Split sentence into words using split , you will will have a sequence of words, we did this on Day 8
  //Generate word length sequence (can use map or yield)
  //Filter only words of length over 5
  //print word lengths for every word
  //print the long words

  //you are allowed to use yield or map/filter

  val sentence = readLine("Enter any sentence, please:\n")

  val words = sentence.split(" ")
  println(s"The words from sentence:\n${words.mkString(",")}")

  val wordsLength = words.map(_.length)
  println(s"Word lengths:\n${wordsLength.mkString(",")}")

  val wordsOver5 = words.filter(it => it.length > 5)
  println(s"Words of length over 5:\n${wordsOver5.mkString(",")}")

  //for (word <- words){
  //println(s"$word length is ${word.length}")
  //}

  words.foreach(word => println(s"$word length is ${word.length}"))


}
