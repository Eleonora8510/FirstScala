package com.github.Eleonora8510

import scala.io.Source

object Day17ExerciseReadPoem extends App{
  //TODO read stopping by poem from src/resources/stopping_by.txt
  //TODO get poem name - it is the first line
  //TODO get poet - it is in the 2nd line but we want just the poet

  //TODO Get all lines which contain "woods" somewhere in the text
  //so instead of startsWith we use contains

  val FilePath = "src/resources/stopping_by.txt"

  val bufferedSource = Source.fromFile(FilePath)
  val text = bufferedSource.getLines().toArray
  bufferedSource.close()

  val poemName = text.head
  println(s"Poem name: $poemName\n")

  // One method:
  //val poetName = text(1).drop(3)

  // Another method:
  val lengthOfSecondLine:Int = text(1).length
  val poetName = text(1).slice(3,lengthOfSecondLine)
  println(s"Poet name: $poetName\n")

  val woodsLines = for (line <- text if line.contains("woods")) yield line
  println("Lines with the word 'woods':\n")
  woodsLines.foreach(println)

}
