package com.github.Eleonora8510

object Day3TypeCasting extends App{
  println("Type casting different data types")
  // https://docs.scala-lang.org/tour/unified-types.html
  val a= 200
  val b = a.toByte // convert to byte
  println(a,b)
  println(b.toInt)
  val c = 127
  val d = 128
  val e = 129
  println(c.toByte, d.toByte, e.toByte)
  println(1000 % 256, (1000 % 256 - 128), 1000.toByte)

  val myInt = 2_000_000_000
  //val myFace = "jkl"
  //val alsoNumber = myFace.toInt

  val myPi = Math.PI
  val ancientPi = myPi.toInt
  val ancientPiFloat = ancientPi.toDouble
  println(myPi, ancientPi, ancientPiFloat)

  val myString = "44252621"
  val myNumber = myString.toInt
  println(myString, myNumber)
  val myName = "Eleonora"
  //val myNameNum = myName.toInt
  val emoji = '\u263a'
  println(emoji.toInt)

}
