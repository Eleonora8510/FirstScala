package com.github.Eleonora8510


class Animal(val name:String, val animalType:String, val likes:String="", val sound:String="", val age:Int) {
  //  //BONUS
  //  //TODO add class method meet which has a parameter of contact:String
  //  //TODO this meet should decide whether to greet if they like the contact
  //  //TODO to run away if they do not like the contact

  val makeSound = animalType match {
    case "dog" => "woof"
    case "dolphin" => "click"
    case "goose" => "cackle"
    case "fox" => "yelp"
    case "kangaroo" => "chortle"
    case "cat" => "meow"
    case _ => "brrrrr" // for unknown animals
  }

//  def meet(contact:String): Unit = {
//    if (likes(contact)) { //so if the contact is in the Set then this will be true
//      println("Hello there, I like that \u263a \n") // ☺
//    }
//    else println("Nope. Byeeeee.\n")
//  }

}
object Day12ExerciseAnimals extends App{

  val dog = new Animal("Goofy", "dog",age = 5 )
  println(s" ${dog.animalType.capitalize} ${dog.name} makes " + dog.makeSound)

  val dolphin = new Animal("Dolly", "dolphin", age=2)
  println(s" ${dolphin.animalType.capitalize} ${dolphin.name} makes ${dolphin.makeSound}")

  val cat = new Animal("Murkė","cat", age = 8)
  println(s" ${cat.animalType.capitalize} ${cat.name} makes ${cat.makeSound}")
}
