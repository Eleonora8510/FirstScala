package com.github.Eleonora8510

import scala.io.StdIn.readLine

object Tic_tac_toe extends App{

  val table : String = "1 2 3\n4 5 6\n7 8 9"
  val gameStartCondition = table

  def gameEndConditionRegEx(tableString:String):Boolean = {
    val gameEndCondition = Array(raw"(o\s){2}o".r,
      raw"(o\s.\s.\s){2}o\s.\s.".r,
      raw"(.\so\s.\s){2}.\so\s.".r,
      raw"(.\s.\so\s){2}.\s.\so".r,
      raw"o(\s.){3}\so(\s.){3}\so".r,
      raw"(.\s){2}(o\s.\s){2}o(\s.){2}".r,
      raw"(x\s){2}x".r,
      raw"(x\s.\s.\s){2}x\s.\s.".r,
      raw"(.\sx\s.\s){2}.\sx\s.".r,
      raw"(.\s.\sx\s){2}.\s.\sx".r,
      raw"x(\s.){3}\sx(\s.){3}\sx".r,
      raw"(.\s){2}(x\s.\s){2}x(\s.){2}".r,
      raw"([xo]\s){8}[xo]".r // no winner
    )
    val trueOrFalse = for (n <- gameEndCondition) yield n.matches(tableString)
    trueOrFalse.contains(true)
    }

  val playerA = readLine("Player A what is your name? ")
  val playerB = readLine("Player B what is your name? ")
  val signPlayerA = readLine(s"Which sign do you want $playerA: o or x (Lowercase o or lowercase x)? ").toCharArray.head
  val signPlayerB = if (signPlayerA == 'o') 'x' else 'o'
  println(s"$playerB, your sing is $signPlayerB")

  println(s"Player A - $playerA and Player B - $playerB  let us play Tic-Tac-Toe!")

  var currentStateTable = gameStartCondition
  var isPlayerATurn = true // so A goes first

  while (!gameEndConditionRegEx(currentStateTable)){
    val currentPlayer = if (isPlayerATurn) playerA else playerB
    println(s"The Tic-Tac-Toe table now is:\n$currentStateTable")
    val move = readLine(s"Which place do you choose $currentPlayer? ").toCharArray.head //TODO limit from 1 until 9, and only not chosen places
    currentStateTable = if (isPlayerATurn) currentStateTable.replace(move, signPlayerA) else currentStateTable.replace(move, signPlayerB)
    isPlayerATurn = !isPlayerATurn
  }

  println(currentStateTable)
  if (raw"([xo]\s){8}[xo]".r. matches(currentStateTable)){
    println(s"Game ended. There is no winner in this game.")
  } else {
    val winner = if (isPlayerATurn) playerB else playerA
    val loser = if (!isPlayerATurn) playerB else playerA
    println(s"Game ended. Congratulations $winner! Better luck next time $loser.")
  }

}
