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

  // inevitably in most applications we will have some state that we want to keep track of (sledzic, sekti)
  //here it is simple enough state that we can use a few variables
  // at some point we will want to structure this game/app state into separate object based on some class

  var currentState = startingCount
  var isPlayerATurn = true // so A goes first

   def clampMove(move: Int, min: Int = minMove, max: Int = maxMove, verbose: Boolean = true):Int = {  // užspaustas ėjimas
      if (move > max){
        if (verbose) println(s"$move was too much, you wil have to settle for $max")
        max
      } else if (move < min) {
        if (verbose) println(s"$move was too little, you wil have to settle for $min")
        min
      } else {
        move
      }

   }

  // main loop - while there are some matches play on
  // TODO implement PvP (Player versus Player) - computer only checks the rules
  while (currentState > gameEndCondition){
    val currentPlayer = if (isPlayerATurn) playerA else playerB
    //show the game state
    println(s"Currently there are $currentState matches on the table")
    val move = readLine(s"How many matches do you want to take $currentPlayer? (1-3) ").toInt //TODO error checking
    //TODO limit the number of matches according to the rules
    val safeMove = clampMove(move, minMove, maxMove)
    currentState -= safeMove
    isPlayerATurn = !isPlayerATurn // toggle trick to change a boolean to reverse version of present
    // play the game
  }

  // TODO PvC - Player versus Computer - you will need to add some logic to the computer

  //end cleanup here we just print some game state and congratulations
  //TODO add saving to Database, stats, etc

  val winner = if (isPlayerATurn) playerA else playerB
  val loser = if (!isPlayerATurn) playerA else playerB
  println(s"Game ended. Congratulations $winner! Better luck next time $loser.")

 // TODO implement multiple games

  // no clean up at the moment


}
