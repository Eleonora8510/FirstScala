package com.github.Eleonora8510

import scala.io.StdIn.readLine

// https://docs.scala-lang.org/overviews/scala-book/try-catch-finally.html

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
  val saveDst = "src/resources/nim/scores.csv"
  val db = new NimDB("src/resources/nim/nim.db")
  val startingCount = 21
  val gameEndCondition = 0
  val minMove = 1
  val maxMove = 3

  // get player names
  val playerA = readLine("Player A what is your name? ")
  var playerB = readLine("Player B what is your name? (press ENTER for computer)")
  if (playerB == "") playerB = "COMPUTER" //TODO see if you can do the previous 2 lines at once

  // TODO more computer levels
  def getComputerMove():Int = 2 //TODO add more complex logic later
  //computer can be made to play perfectly
  //or we could add some randomness

  //main loop - while there are some matches play on
  //TODO implement PvP - player versus player - computer only checks the rules

  def getHumanMove(currentPlayer:String): Int = {
    var needsInteger = true //we use this as a flag for our code
    var myInteger = 0
    //so we keep going until we get an input which we can cast to integer
    while (needsInteger) {
      val moveInput = readLine(s"How many matches do you want to take $currentPlayer? (1-3) ")
      //https://alvinalexander.com/scala/scala-try-catch-finally-syntax-examples-exceptions-wildcard/
      try {
        myInteger = moveInput.toInt //this type Casting will throw an exception on bad input
        needsInteger = false //IMPORTANT! this line will not execute if error is encountered
      } catch {
        //It is considered good practice to catch specific errors relevant to your code
        case e:NumberFormatException => println(s"That is not a number! + $e") //for users you would not print $e
        // handling any other exception that might come up
        case unknown => println("Got this unknown exception we need an integer!: " + unknown)
      }
    }
    myInteger
  }

  var isNewGameNeeded = true
  while (isNewGameNeeded) {
    println(s"Player A - $playerA and Player B - $playerB  let us play NIM")
    val isPlayerAStarting = true // so A goes first
    val nimGame = new Nim(playerA, playerB,startingCount, gameEndCondition, minMove, maxMove, isPlayerAStarting)

    while (nimGame.isGameActive()) {
      nimGame.showStatus()

      val move = if (nimGame.isCurrentPlayerComputer()) {
        getComputerMove()
      } else {
        getHumanMove(nimGame.currentPlayer)
      }
      nimGame.removeMatches(move)
      nimGame.nextPlayer()
    }
    nimGame.showStatus()
    nimGame.printMoves()
    nimGame.saveGameResult(saveDst)
    db.insertResult(nimGame.getWinner, nimGame.getLoser)
    nimGame.saveGameScore()
    db.insertFUllScore(nimGame.getMoves)
    db.printTopPlayers()
    db.printTopLosers()

    db.printAllPlayers()

    val nextGameInput = readLine("Do you want to play another game with same players? (Y/N)")
    if (nextGameInput.toLowerCase.startsWith("y"))isNewGameNeeded = true
    else isNewGameNeeded = false

  }

  println("Thank you for playing! Hoping to see you again ;-)")

//  println(s"Player A - $playerA and Player B - $playerB  let us play NIM")
//
//  // inevitably in most applications we will have some state that we want to keep track of (sledzic, sekti)
//  //here it is simple enough state that we can use a few variables
//  // at some point we will want to structure this game/app state into separate object based on some class
//
//  //var currentState = startingCount
//  var isPlayerAStarting = true // so A goes first
//
//  //TODO create a new object holding all the information necessary for a game nim from this class Nim
//  val nimGame = new Nim(playerA, playerB,startingCount, gameEndCondition, minMove, maxMove, isPlayerAStarting)
//
//
//
//  while (nimGame.isGameActive()) {
//    //show the game state
//    //    println(s"Currently there are $currentState matches on the table")
//    nimGame.showStatus()
//
//    val move = if (nimGame.isCurrentPlayerComputer()) {
//      getComputerMove()
//    } else {
//      getHumanMove(nimGame.currentPlayer)
//    } //TODO error checking
//    nimGame.removeMatches(move)
//    nimGame.nextPlayer()
//  }
//  //TODO PvC - player versus computer you will need to add some logic to the computer, add more levels
//
//  //end cleanup here we just print some game state and congratulations
//
//
//  //val winner = if (isPlayerATurn) playerA else playerB
//  //val loser = if (!isPlayerATurn) playerA else playerB
//  //println(s"Game ended. Congratulations $winner! Better luck next time $loser.")
//
//  nimGame.showStatus()
//  nimGame.printMoves()
//
//
//  //Day27Persistence.saveGameResult(saveDst, nimGame.getWinner(), nimGame.getLoser())
//
//  nimGame.saveGameResult(saveDst)
//  db.insertResult(nimGame.getWinner, nimGame.getLoser)
//  nimGame.saveGameScore()
//  db.insertFUllScore(nimGame.getMoves)
//  db.printTopPlayers()
//  db.printTopLosers()
//  //print game status again
//
//  db.printAllPlayers()
//
//  //TODO implement multiple games
//  val nextGameInput = readLine("Do you want to play another game with same players? (Y/N)")

  // TODO add support for new player names

}
