package com.github.Eleonora8510

object Day11ExercisePangram extends App {

  //TODO write a pangram tester
  //https://en.wikipedia.org/wiki/Pangram
  //check if text contains every letter of an alphabet at least once
  //for this task consider upper and lower case the same
//  def isPangram(text:String, alpha:String="abcdefghijklmnopqrstuvwxyz"):Boolean = {
//    val setForChecking = scala.collection.mutable.Set[Char]()
//    for (c <- alpha) {
//      if (text.toLowerCase contains c) setForChecking += c
//    }
//
//    setForChecking == alpha.toSet
//  }

  def isPangram(text:String, alpha:String="abcdefghijklmnopqrstuvwxyz"):Boolean = {
    val charSet = text.toLowerCase.toSet
    val alphaSet = alpha.toSet //when compiling your program these internal values will be optimized away
    alphaSet.subsetOf(charSet) //last line of a function is what is being returned
  }

  //one liner
  //def isPangram(text:String, alpha:String="abcdefghijklmnopqrstuvwxyz"):Boolean = {alpha.toSet.subsetOf(text.toLowerCase.toSet)}

  val myTestText = "The five boxing wizards jump quickly."
  println(isPangram(myTestText)) //should be true

  val litTestText = "Įlinkusi fechtuotojo špaga blykčiodama gręžė apvalų arbūzą."

  val litAlpha = "Aa Ąą Bb Cc Čč Dd Ee Ęę Ėė Ff Gg Hh Ii Įį Yy Jj Kk Ll Mm Nn Oo Pp Rr Ss Šš Tt Uu Ųų Ūū Vv Zz Žž".replace(" ","").toLowerCase
  println(litAlpha)
  val litAlphaClean = litAlpha.toSet.mkString("")
  println(litAlphaClean)
  println(isPangram(litTestText, alpha = litAlphaClean))





}
