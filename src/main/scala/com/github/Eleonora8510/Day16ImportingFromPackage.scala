package com.github.Eleonora8510

case class Laptop(name:String, speed:Double)

object Day16ImportingFromPackage extends App{
  println("Try to import from package")
  val myLaptop = Laptop("Ela", 4.5)
  println((myLaptop))


}
