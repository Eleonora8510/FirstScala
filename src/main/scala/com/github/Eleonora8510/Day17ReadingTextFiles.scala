package com.github.Eleonora8510

import com.github.Eleonora8510.Util.{getLinesFromFile, getTextFromFile}

import scala.io.Source

object Day17ReadingTextFiles extends App{
  println("Let's read some text files")

  // let's check our current working directory because we need to know to have correct relative path
  println(System.getProperty("user.dir"))

  // \ is used to escape some characters
  // one solution would be to escape those \ -> \\
  val absoluteFilePath = "C:\\Users\\ELEONORA\\IdeaProjects\\FirstScala\\src\\resources\\two_roads.txt"
  val relativeFilePath = "src/resources/two_roads.txt"


  // print all characters one by one
  // for (character <- Source.fromFile(filePath)) println(character) // turns out that we read big string of characters

  // print all lines
  // for (line <- Source.fromFile(filePath).getLines) println(line)

 // val myPoem = Source.fromFile(absoluteFilePath).mkString // we turn stream of characters into one big string
 val myPoem = Source.fromFile(relativeFilePath).mkString
  println(myPoem)

  //val myPoemLines = Source.fromFile(absoluteFilePath).getLines().toArray // to Array because iterator was lazy on demand
  val myPoemLines = Source.fromFile(relativeFilePath).getLines().toArray

  println("*"*40)

  println("Printing poem line by line: \n")
  for (line <- myPoemLines) println(line)


  val myText = getTextFromFile(relativeFilePath)
  println(myText)



  val maxLines = 5
  println(s"FIRST $maxLines lines")
  val myLines = getLinesFromFile(relativeFilePath)
  myLines.slice(0,maxLines).foreach(println)
  //same result as previous operation but here we create the substring first, above we printed line by line
  println(myLines.slice(0,maxLines).mkString("\n")) //this should be slightly faster

  println("Lines starting with And")
  val andLines = myLines.filter(_.startsWith("And"))
  andLines.foreach(println)

  val roadsLines = myLines.filter(_.contains("roads")) //text can be anywhere in the line
  roadsLines.foreach(println)

//  //alternative to filter is to use yield it is more flexible because you can also perform some mappings
//  //with filter we would have to use map as well
//  val endsWithComma = for (line <- myLines if line.endsWith(",")) yield line.toUpperCase
//  endsWithComma.foreach(println)
//
//  val firstLine = myLines(0) //could also use myLines.head
//  println(firstLine)
  // one catch is that file remains opened until the program finishes running
}
