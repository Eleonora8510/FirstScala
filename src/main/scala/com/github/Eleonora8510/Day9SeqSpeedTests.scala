package com.github.Eleonora8510

import com.github.Eleonora8510.MyUtil.printDeltaMs

object Day9SeqSpeedTests extends App{
  println("Testing various sequences and looping constructions")
  val t0 = System.nanoTime() //so I get current time nanoseconds
  val bigNumbers = (0 to 1_000_000).toArray
  val t1 = System.nanoTime()
  val delta = t1 - t0
  println(s"It took $delta nanoseconds to create 1 million and 1 number in increasing order")
  printDeltaMs(t0, t1)

  val t2 = System.nanoTime()
  val biggerNumbers = bigNumbers.map(_+100)
  val t3 = System.nanoTime()
  printDeltaMs(t2, t3, taskName = "add 100")

  val t4 = System.nanoTime()
  val biggerNumberYield = for (n<-bigNumbers) yield n+100
  val t5 =System.nanoTime()
  printDeltaMs(t4, t5, "yield +100")

  //val numberBuffer = ArrayBuffer[Int]()
  //for


}
