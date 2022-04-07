package com.github.Eleonora8510

object Day7Strings extends App {
  println("Let's look some string fun! \uD830\uDE01")

  val food = "kartupelis"

  println(food.charAt(0))
  println(food(0))

  val alphabet = "abcdefghijklmnopqrstuvwxyz"
  println(food.substring(2))
  println(alphabet.substring(2))

  println(s"Length of $alphabet is ${alphabet.length}")
  println(alphabet.head)
  println(alphabet.tail)
  println(alphabet.last)

  val firstCharAlso = alphabet.head // alphabet(0)
  val secondChar = alphabet(1)
  println(firstCharAlso, secondChar)

  println(s"$firstCharAlso has ASCII code ${firstCharAlso.toInt}")

  println(food.toUpperCase())

  val name = "Mąka"
  println(s"Second character of $name is ${name(1)} with unicode of ${name(1).toInt}")

  val smiley = "😁"
  val smiley2 = "\u263a"
  val emoji = "\u1F60"
  val emoji2 = "\uD83E\uDD23"
  val emoji3 = "\uD83D\uDE00"
  println(smiley, smiley2, emoji, emoji2, emoji3)

  val lithuanianLetterChar = 'č'
  val lithuanianLetterString = "č"
  println(lithuanianLetterString)
  //println(lithuanianLetterString(1))

  println(smiley, smiley(0).toInt)
  println(smiley, smiley(1).toInt)
  println(smiley(0), smiley(1))

  val greeting = "Welcome to Riga"
  val greeting2 = "welcome to vilnius"

  println(greeting.toLowerCase)
  println(greeting.capitalize) // Scala adds capital
  println(greeting2.capitalize)
  println(s"$alphabet starts with  abc", alphabet.startsWith("abc"))
  println(s"$alphabet ends with  xyz", alphabet.endsWith("xyz"))

  val drink = "coffee with milk"
  println("Is there milk in my coffe?", drink.contains("milk"))

  //strings are immutable therefore if need to change smth we need to make a  new string

  val newDrink = drink.replace("coffee", "tea")
  println(newDrink)
  println(newDrink.capitalize)

  val dirtyString = " Riga is a port city "
  println(dirtyString.trim)
  println(dirtyString.trim.toUpperCase.tail.tail.tail)
  println(dirtyString.trim.toUpperCase.substring(3))

  println((alphabet.substring(3, 8))) //defgh

  val numbers = "0123456789"
  println(numbers.substring(3, 8))
  println(numbers.subSequence(3, 8))

  println(numbers == "0123456789") // check for equivalence

  println(numbers.indexOf("456")) //it should return 4
  println(alphabet.indexOf("cde")) //it should return 2
  println(alphabet.indexOf("notsuchstring")) //it should return -1

  val myName = "Valdis"
  for (c <- myName) {
    println(s"Current char is $c")
  }

  for ((c, i) <- myName.zipWithIndex) {
    println(s"Current char is $c at index $i")
  }

  // so for new strings I advice using our string interpolation with s"" syntax
  val domicile = s"$myName lives in ${dirtyString.trim.substring(0, 4)}"

  println(domicile)

  val newString = myName + " likes " + food
  println((newString))

  println(" " * 10 + "*" * 5) //this can save a lot of looping time for certain tasks

}
