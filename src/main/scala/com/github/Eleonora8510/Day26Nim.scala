package com.github.Eleonora8510

import scala.io.StdIn.readLine

object Day26Nim extends App{
  //TODO implement basic version of https://en.wikipedia.org/wiki/Nim
  //https://en.wikipedia.org/wiki/Nim#The_21_game


  //TODO setup/config - set data/state what is needed for the application
  //TODO main application/game loop - it could be a loopless - if you process data only once
  //TODO cleanup - close database connections, files etc
  //No plan survives first contact with the enemy - who said it first?
  //It is normal (especially Agile development) to adjust as you development

  //NIM specific TODO
  //setup
  //we will start with 21 matches/tokens
  val startingCount = 21
  val gameEndCondition = 0
  val minMove = 1
  val maxMove = 3

  // TODO get player names
  val playerA = readLine("Player A what is your name? ")
  val playerB = readLine("Player B what is your name? ")

  println(s"Palyer A - $playerA and Pplayer B - $playerB  let us play NIM")



  // main loop - while there are some matches play on
  // implement PvP (Player versus Player) - computer only checks the rules
  // PvC - Player versus Computer - you will need to add some logic to the computer

  // no clean up at the moment


}
