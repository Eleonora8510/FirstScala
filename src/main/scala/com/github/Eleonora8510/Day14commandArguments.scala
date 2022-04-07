package com.github.Eleonora8510

object Day14commandArguments extends App{
  println("Starting main function")
  for (arg <- args){
    println(s"Going to do something with argument: $arg type is ${arg.getClass}")
  }
  println("All done")

  Day14noApp.main(Array("Oho", "5.2134", "546"))
}
