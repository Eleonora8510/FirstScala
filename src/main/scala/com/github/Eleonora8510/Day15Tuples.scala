package com.github.Eleonora8510

object Day15Tuples extends App {
  //https://docs.scala-lang.org/tour/tuples.html#inner-main
  //https://stackoverflow.com/questions/54701769/convert-tuple-to-array-in-scala

  println("Let's make some tuples")

  val myTuple = ("Ela", 15, 3.456, "CTU")
  println(myTuple)
  println(myTuple._1)

  //unpacking tuples
  val (name, age, pi, university) = myTuple
  println(name)
  println(age, pi)

  // looping
  // for (it <- myTuple) {
  //   println(it)
  // }
  //  val myArray = List(myTuple)
  //
  //https://stackoverflow.com/questions/54701769/convert-tuple-to-array-in-scala

  val myArray = myTuple.productIterator.toArray
  for (it <- myArray) println(it)

  //we could cast each member to string
  val stringArray = myArray.map(_.toString)
  for (it <- stringArray) println(it)

  //Users may sometimes find it hard to choose between tuples and case classes. Case classes have named elements. The names can improve the readability of some kinds of code

}
