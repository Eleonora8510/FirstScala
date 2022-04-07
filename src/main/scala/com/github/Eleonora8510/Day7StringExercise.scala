package com.github.Eleonora8510

object Day7StringExercise extends App {
  //TODO
  def processString(text:String, uppercaseChars:String ="", needsTrim:Boolean=false, suffix:String=""):String = {
    //TODO first trim string if it needs trimming from the argument
    //TODO replace All characters in uppercaseChars with their uppercase versions
    //you will need to write a loop
    //you will probably want to use var to store a temporary string that you keep reweriting
    //return newly created string


    var trimmedString = ""
    if (needsTrim) {
      trimmedString = text.trim
    } else {
      trimmedString = text
    }

    //val trimmedString = if (needsTrim) text.trim else text

    //var newString = ""
    val sb = new StringBuilder("")
    for (c <- trimmedString){
      if (uppercaseChars.contains(c)) {
        sb += c.toUpper
      } else {
        sb += c
      }
    }
    sb ++= suffix
    sb.toString
  }

  println(processString("abracadabra", "cr")) //should print abRaCadabRa
  println(processString("   abracadabra  ", "cr", needsTrim = true)) //should print abRaCadabRa
  println(processString("   abracadabra  ", "cr", needsTrim = true, "END OF MY STRING")) //should print abRaCadabRa

}