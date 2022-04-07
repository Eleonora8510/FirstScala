package com.github.Eleonora8510

object Day8Sequences extends App {
  println("Need for sequences")

  //val a1 = 3
  //val a2 = 8
  //val a3= 13

  // this is sille way to store more than a couple related data items
  val mySeq = Seq(3, 8, 13) // immutable sequence of integers (in this case)
  println((mySeq))
  //val numbers = 1 to 20.toSeq //does not quite because range is already a sequence
  val numbers = (1 to 20).toList
  println(numbers)
  println(numbers.head)
  println(numbers.tail)
  println(numbers.last)
  println(numbers(0))
  println(numbers(19), numbers(numbers.length - 1))

  val numArray = numbers.toArray // just another type of Sequence
  println(numArray.getClass) // array of integers

  val againSequence = numArray.toSeq // we can go from Array to generic Sequence if we want
  println(againSequence)

  for (number <- numbers) {
    println(s"My lucky number is $number")
  }

  val evenNumbers = for (number <- numbers if number % 2 == 0) yield number //yield gets us a new sequence items one at a time
  println(evenNumbers)

  val oddNumbers = for (number <- numbers if number % 2 == 1) yield number
  println(oddNumbers)

  val manyNumbersThatDivideBy3 = for (num <- 0 to 100 if num % 3 == 0) yield num
  println(manyNumbersThatDivideBy3)
  println(manyNumbersThatDivideBy3.slice(0, 10)) // just 10 first numbers

  //val squares = for (number <- oddNumbers) yield Math.pow(number,2)
  val oddSquares = for (number <- oddNumbers) yield Math.pow(number, 2).toInt
  println(oddSquares)

  println(oddSquares(3))

  //val mutableSquares = scala.collection.mutable.Seq(oddSquares)
  val myMutableArray = scala.collection.mutable.ArraySeq(1, 4, 6, 18, 7, 8)
  println(myMutableArray)
  myMutableArray(3) = 35 // changed the context of 4th item in my mutable Sequence
  println(myMutableArray)

  val myArrayBuffer = scala.collection.mutable.ArrayBuffer(5, 2)
  println(myArrayBuffer)
  myArrayBuffer += 6
  println(myArrayBuffer)

  //here is an example how to create blank mutable buffer for integers
  val cleanSquareBuffer = scala.collection.mutable.ArrayBuffer[Int]() // this way scala knows we will hold integers here
  for (n <- 0 to 10) {
    val mySquare = n * n
    cleanSquareBuffer += mySquare
  }

  println(cleanSquareBuffer)
  // usually we want to change to immutable
  val immutableSquares = cleanSquareBuffer.toSeq
  println(immutableSquares)

  for (n <- 100 to 310) {
    cleanSquareBuffer += n * n
  }
  val newFixedSquares = cleanSquareBuffer.toSeq
  println((cleanSquareBuffer))

  cleanSquareBuffer.clear() /// this clears the buffer so we can reuse it

  println(numbers)
  val firstThree = numbers.take(3)
  println(firstThree)
  val allButFirstFour = numbers.drop(4)
  println(allButFirstFour)

  println(numbers.mkString(",")) // makes a string with separator ,
  println(numbers.mkString("[", ",", "]")) // start with [ and end with ], and separator ,


}
