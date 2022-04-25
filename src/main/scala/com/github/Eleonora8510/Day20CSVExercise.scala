package com.github.Eleonora8510

import com.github.Eleonora8510.Util.myRound

object Day20CSVExercise extends App{
  val src = "src/resources/csv/fruitvegprices-19apr22.csv"
  val lines = Util.getLinesFromFile(src)

  val splitLines = for (line <- lines) yield line.split(",")

  def arrayToVeggie(arr:Array[String]):Veggie = {
    Veggie(arr(0), arr(1), arr(2), arr(3),arr(4).toDouble, arr(5))
  }


  val veggies = splitLines.tail.map(arrayToVeggie)

  val expensiveApples = veggies.filter(_.item == "apples").sortBy(_.price).reverse
  println(s"Top 5 the most expensive apple entries: \n")
  expensiveApples.take(5).foreach(println)

  println("\n")

  val cheapApples = veggies.filter(_.item == "apples").sortBy(_.price)
  println(s"Top 5 the least expensive apple entries: \n")
  cheapApples.take(5).foreach(println)

  println("\n")

  val lettuce = veggies.filter(_.item == "lettuce")
  val averagePriceOfLettuce = ((lettuce.map(_.price).sum) / lettuce.length)
  val lettucePriceRounded = myRound(averagePriceOfLettuce, 2)
  println(s"Average price for lettuce $lettucePriceRounded")

  println("\n")

//not working
  val year = raw"2022-\d{2}-\d{2}".r.toString()
  val tomatoes = veggies.filter(_.item == "tomatoes").filter(_.variety == "cherry").filter(_.date == year)
  tomatoes.take(5).foreach(println)

  //TODO get the top 5 most expensive apple entries
  //TODO get the least expensive 5 apple entries

  //TODO get average price for lettuce

  //TODO get cherry tomatoes pricing min, max, mean for year 2022

  //TODO extra credit challenge get average price for lettuce by year

  //two approaches - one is simply hardcode starting and ending years and filter by those
  //you might not even need to extract year simply lexicographical filering should work

  //even better approach use groupBy
  // hint: use groupBy but first you would need to modify case class with Year field(value)
  //alternative to creating a Year entry would be to split date field while grouping and group by first portion
  // https://alvinalexander.com/scala/how-to-split-sequences-subsets-groupby-partition-scala-cookbook/

}
