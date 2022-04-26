package com.github.Eleonora8510

object Day21ReadingJSONWithUPickle extends App{
  val src = "src/resources/json/fruitFacts.json"

  val rawText = Util.getTextFromFile(src)
  println(rawText.take(100))

  //let's use uPickle library to parse the raw Text into some structure
  val data = ujson.read(rawText)
  println(data)
  //in order for arr method to work I need to know that my top level of data is actually an array (not an object or just a string or number)
  val arrData = data.arr.toArray
  println(arrData.head)
  println(arrData.last)

  //with o I indicate that it is an object
  val fruits = for (o <- arrData) yield {
    Fruit(o("genus").str,
      o("name").str,
      o("id").num.toInt,
      o("family").str,
      o("order").str,
      o("nutritions")("carbohydrates").num,
      o("nutritions")("protein").num,
      o("nutritions")("fat").num,
      o("nutritions")("calories").num.toInt,
      o("nutritions")("sugar").num
    )
  }

  fruits.take(3).foreach(println)

  println("\n")

  //TODO find most calorie dense fruit - it looks the data is per 100grams maybe someone can verify this?
  val mostCaloriesDense = fruits.sortBy(_.calories).reverse
  println("The most calories dense fruits:")
  mostCaloriesDense.take(5).foreach(println)
  println("\n")

  //TODO find top 5 fattiest fruits
  val fattiestFruits = fruits.sortBy(_.fat).reverse
  val fattiestFruitsSplited = fattiestFruits
  println("The fattiest fruits:")
  fattiestFruits.take(5).foreach(println)
  println("\n")

  //TODO find top 5 protein sources for fruits
  val richestInProtein = fruits.sortBy(_.protein).reverse
  println("The richest in protein fruits:")
  richestInProtein.take(5).foreach(println)
  println("\n")

  //TODO find 5 least sugary fruits
  val leastSugary = fruits.sortBy(_.sugar)
  println("The least sugary fruits:")
  leastSugary.take(5).foreach(println)
  println("\n")

  //TODO find 5 fruits with most carbohydrates that are not sugars (so difference between carbohydrates and sugar)
  val highestCarbohydrates = fruits.sortBy(_.carbohydrates).reverse
  println("The richest in carbohydrates fruits:")
  highestCarbohydrates.take(5).foreach(println)
  println("\n")

  //you can add some extra conclusions, statistics as well

  println("The durian and the passionfruit are richest in calories, fat, proteins and carbohydrates pre 100 grams")
  println("Banana is one of the most high-calorie and high in carbohydrates per 100 grams \n")
  println("The information about fruityvice dataset:  https://www.fruityvice.com/doc/index.html")

}
