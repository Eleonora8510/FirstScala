package com.github.Eleonora8510

import scala.util.Random


object FinalProjectRandomDraw extends App {
  val src = "src/resources/csv/courseid_5_participants.csv"

  val lines = Util.getLinesFromFile(src)
  lines.foreach(println)

  val emails = lines.tail.map(_.split(",").last)
  //  emails.foreach(println)

  //https://alvinalexander.com/source-code/scala-how-to-shuffle-list-randomize/
  //so Scala Random shuffle works on List and Vector which are Scala Native
  //not on Array which is lower level and from Java

  Random.setSeed(42) //so the pseudo-random operations will be exactly the same each time we ran program
  //of course instead of 42 we could use any number
  //in this way we get a reproducable pseudo-random drawing
  val randomizedEmails = Random.shuffle(emails.toList).toArray
  println("Randomized emails")
  randomizedEmails.foreach(println)

  //so I create a tuple of emails from both directions
  val groups = for ((a,b) <- randomizedEmails zip randomizedEmails.reverse) yield Array(a,b)

  val groupsForCSV = for ((a,b) <- randomizedEmails zip randomizedEmails.reverse) yield s"$a,$b"

  println("Group composition is:")
  groups.foreach(group => println(group.mkString(",")))

  Util.saveLines("src/resources/csv/groups.csv", groupsForCSV.take(5))
}