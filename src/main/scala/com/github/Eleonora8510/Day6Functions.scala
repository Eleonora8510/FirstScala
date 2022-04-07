package com.github.Eleonora8510

object Day6Functions extends App{
  println("Let's go it something!")

 // println("Let's eat potatoes!")
  //println("Let's eat potatoes!")
  //println("Let's eat potatoes!")

  //for (_ <- 0 until 3) println("Eating tons of potatoes")

  //for (_ <- 1 until 3) {
    //println("Let's sit down at a table")
    //println("Pick up our")
   // println("Let's eat potatoes")
  //}
  def sitdown(): Unit = {
      println("Take the chairs")
      println("Sit down at a table")
    }

  def eat(): Unit = {
    sitdown()
    //println("Let's sit down at a table")
    println("Pick up our utensils")
    println("Let's eat potatoes!")
    println("Ask for a drink")
  }
//
 // eat()
 // println("I do lots of other things")
 // println("I remember that I need to eat again")
  //eat()

  //for (_ <- 0 until 4) eat()

  // arguments / parameters
  def orderFood(dish: String, waiterName: String): Unit = {
    println(s"Waiter, I'd like to order $dish")
    println(s"${dish.capitalize} is one of my favourites")
    println(s"Thank you, $waiterName!")
  }

  orderFood(dish = "ice cream", "Woldemars")
  orderFood(dish= "beet soup", "Alice") // full syntax but for a single argument not neededd
  orderFood(dish= "mashed potatoes", "Arnolds")

  def printAdd(a: Int, b: Int): Unit = println(s"Result of $a + $b = ${a+b}")
  printAdd(3,5)
  printAdd(13,-25)

  val c = add(10,50)
  println(s"result is $c")

  def multi(a: Int, b:Int):Int = a*b

  val a = 500 // global to my object and does not conflict with  a and b function parameters
  def add(a: Int, b: Int): Int = {
    a+b
  }

  val printResult:Unit = multi(add(2,3), add(5,10))
  println(s" so (2+3)*(5+10) = $printResult")

  // default values for functions can shorten code
  def greetWaiter(name:String = "Joe", isYelling: Boolean = false): Unit ={
    val greeting = s"Hello there $name"
      if (isYelling){
        println(greeting.toUpperCase)
      }else{
        println(greeting)
      }

  }

  greetWaiter()// default value Joe is used
  greetWaiter("Ann")
  greetWaiter("Ann", isYelling = true) // for booleans it is suggested to use full syntax


  //round function

}
