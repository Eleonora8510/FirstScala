package com.github.Eleonora8510

import scala.collection.mutable.ArrayBuffer

object Day9MapFilter extends App{
  println("Mapping and filtering sequences")
  //the big idea is to have your loops done for you - not write loops by hand

  val numbers = (0 to 12).toArray
  println(numbers.mkString(","))

  val squares = numbers.map(n=> n*n) //go through all items in my collections and map onto new collection
  println(squares.mkString(","))

  val squaresAgain = for (n<-numbers) yield n*n
  println(squaresAgain.mkString(","))

  //less efficient would be using a buffer such as

  val squareBuffer = ArrayBuffer[Int]()
  for (n<-numbers){
    squareBuffer += n*n
  }
  val squaresFromBuffer = squareBuffer.toArray
  println(squaresFromBuffer.mkString(","))

  //for simple mapping operations
  val squaresFromMap = numbers.map(Math.pow(_,2).toInt) // in this syntax _ refers to the item automatically
  val plusTen = numbers.map(_+10)
  println(plusTen.mkString(","))




  def complicatesCalculation(n:Int):Double = {
    (n-32)*9/5
  }

  //val calculatedNumbers = numbers.map(complicatesCalculation)
  //val calculatedNumbers = numbers.map(complicatesCalculation(_)) // slightly longer way of writing
  val calculatedNumbers = numbers.map(item=>complicatesCalculation(item)) // slightly longer way of writing
  println(calculatedNumbers.mkString(","))

  val myName = "Eleonora"
  val myUnicode = myName.map(_.toInt)
  println(myUnicode.mkString(","))

  val myChars = myUnicode.map(_.toChar)
  println(myChars.mkString(","))
  println(myChars.mkString(""))

  // Second related idea is a filter instead of mapping smth we filter by some so called predicate some condition

  //val myOddNumbers = numbers.filter(it => it % 2 ==0)
  val myOddNumbers = numbers.filter(it => true)
  //val myOddNumbers = numbers.filter(it => false)
  println(myOddNumbers.mkString(","))

  val evenNumbers = numbers.filter(_%2 ==0) // so same as saying _ => % 2 == 0 or n => n %2 ==0
  println(evenNumbers.toSeq)

  def complexFilter(n: Int): Boolean = {
    n % 3 == 0
  }

  val myFilteredValues = numbers.filter(complexFilter)
  println(myFilteredValues.toSeq)

  val myNewValues = numbers.filter(_ % 8 == 0).map(_ + 100).map(_ * 3)
  println(myNewValues.toSeq)

  val myNewValuesFromDifferentOrder = numbers.map(_ + 100).map(_ * 3).filter(_ % 8 == 0)
  println(myNewValuesFromDifferentOrder.toSeq)
}
