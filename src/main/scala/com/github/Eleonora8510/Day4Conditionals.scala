package com.github.Eleonora8510

import scala.io.StdIn.readLine

object Day4Conditionals extends App {
  //conditionals let us branch our code, take one of multiple paths
  println("Checking our conditionals")
  //    val a = 80_000
  ////  val a = readLine("Enter value of a(must be number)").toDouble //we will allow floating points as well
  ////
  ////  // remember a could be coming from somewhere else or user input or database or somewhere
  //  if (a > 10) println(s"a is larger than 10, actually a is $a") // so nothing happens if a is not larger than 10
  //
  //  println(s"This always runs no matter the $a")
  //
  //  //above if used a one line syntax which is well to be used for one operation
  //  //often we will want to use curly bracers to put multiple items to run when the if statement is true
  ////
  //  if (a > 600) {
  //    //we could do lots of things
  //    println("Over 600")
  //    println(a)
  //    println("We are still sure a > 600")
  //  }
  ////
  ////  //we can also do if else, show two paths which will be exclusive to each other, only one will be taken
  //  if (a > 8) println(s"a is larger than 10, actually a is $a")
  //  else println("a is less or equal to 8") //so one of these lines is guaranteed to run
  ////
  ////  //if we need to do more work we can use curly braces for multiple instructions
  ////
  //  if (a > 9000) {
  //    println("Wow it is over 9000!")
  //    println(s"a is $a")
  //    //we can do more stuff here when a >9000
  //  } else { //in effect when a <= 9000
  //    println("Sorry not quite 9001...so 9000 or less")
  //    println(s"a is $a") //here of course we could have simplied code by putting
  //  }
  ////  //println(s"a is $a") here
  ////
  ////  //we can keep branching actually with nesting
  //  if (a > 100) {
  //    val b = 33333 // b is local only within these ineer curly bracers
  //    if (a > 500) println("Over 500") //so branch inside a branch
  //    else println("over 100 but less or equal to 500")
  //    println(s"WE can print b just for heck of it $b")
  //    //so b with 33333 is gone after this line
  //  } else println("less than or equal to 100")
  ////
  ////  //
  ////    println(b) //so b is only accessible to within that  {} block after a > 100
  //
  //  //in Scala we if statements actually provide values
  //  //so we can use if as ternary operators to assign some value on some condition
  ////  val d = if (a > 10) 10 else a //so d is a capped at 10 otherwise it is the value of a
  ////  val rawNumber = readLine("Input value to check").toDouble
  ////  println(s"Raw double is $rawNumber")
  ////  val d = if (a > rawNumber) 10 else a //so d is a capped at 10 otherwise it is the value of a
  ////  val d = if (readLine("Enter number to check: ").toInt > 10) 10 else a //so d is a capped at 10 otherwise it is the value of a
  ////  println(s"so value of d is capped at most 10, d is actually $d")
  //  //so we can readLine at the time of assignment
  //  //it might be more prudent to save the value first
  //  val rawInput = readLine("Enter number to check: ").toDouble
  //  val limit = 100
  //  val limitedNumber = if (rawInput > limit) limit else rawInput
  //  println(s"Our limited number is $limitedNumber")
  ////
  //  //now let's determine whether a is even or odd (assuming it is integer first)
  //  if (a.toInt % 2 == 0) println(s"whole part of $a is even")
  //  else println(s"whole part of $a is odd")
  //
  //  //so if you have 3 branches you want to explore we can chain the if else statements
  //
  val a = readLine("Give me an a! ").toDouble
  //  if (a > 50) {
  //    println(s"a is greater than 50, a is actually $a")
  //  } else if (a < 50) {
  //    println(s"a is less than 50, a is actually $a")
  //  } else {
  //    println(s"What do you know? a is exactly 50, just a double check a is $a") //what else could it be other than 50
  //    //but with multi branches it is easy to make a mistake
  //  }
  //
  //  //if you have more than 3 or 4 branches you should consider pattern matching which is another way of branching
  //
  //  //so Scala lets us do expression oriented programming
  //  val b = readLine("okay how about you give me a b?").toInt
  //  //  val minValue =  if (a < b) a else b //of course this covers a == b
  //  //so why is minValue double?
  //  //since minValue could possibly be also double (from a) it has to be double
  //  //if we wanted to be sure it is integer we could put it in parenthesis and cast to Integer
  //  val minValue =  (if (a < b) a else b ).toInt //of course this covers a == b
  //  println(s"out of $a and $b the smallest is $minValue")

  //in practice try to avoid having more than say 4 levels of nested ifs, they are hard to follow
  //this is about max, if your business logic requires more, there are ways to refactor to simplify
  if (a > 100) {
    println(s"a is at least 101 $a")
    if (a > 200) {
      println(s"a is at least 201 $a")
      if (a > 300) {
        println(s"a is at least 301 $a")
      } else {
        println(s"a is over 200 but less than 301 -> $a")
      }
    } else {
      println(s"a is over 100 but less than 201 $a")
    }
  } else {
    println(s"a is less than 101 $a")
  }
}
