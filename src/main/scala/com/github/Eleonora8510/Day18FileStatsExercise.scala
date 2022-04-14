package com.github.Eleonora8510

object Day18FileStatsExercise extends App{
  //TODO download and save a text file of your choosing from gutenberg.org
  //Get Character Count (including whitespace)
  //Get Line Count
  //get Word Count
  //Get average Word Count in each text line

  //You can use the Util functions or maybe add some of your own if you want

  val url = "https://gutenberg.org/cache/epub/19337/pg19337.txt"
  val dst = "src/resources/DickensCh_A_Christmas_Carol.txt"

  val text = Util.getTextFromWebAndSave(url, dst)

  println(s"The book was saved into ${dst}.")

  val lines = Util.getLinesFromFile(dst)

  val characterCount = Util.getCharacterCount(lines)
  println(s"The total number of characters is: ${characterCount}.")

  val lineCount = Util.getLinesFromFile(dst).length
  println(s"The total number of lines is: ${lineCount}.")

  val wordCount = Util.getWordCountPerLine(lines).sum
  println(s"The total number of words is: ${wordCount}.")

  val avgWordCountInLine = wordCount *1.0 / lineCount
  val roundedAvgWordCount = Util.myRound(avgWordCountInLine, 2)
  println(s"The average Word Count in each text line is: ${roundedAvgWordCount}.")



}
