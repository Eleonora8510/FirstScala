package com.github.Eleonora8510.FinalAssignment

import scala.io.StdIn.readLine

/**
 * object in which user chooses what to do in a Task Manager
 */
object FinalProject_ToDo_List extends App{
  println("Hello!\nThis is Task List Manager")
  var userIsActive = true

  val toDo = new ToDo

  /**
   * main loop that offers user choice of actions until he quits
   *
   */
  def setup(): Unit = {
    while (userIsActive) {
      val function =
        readLine("\nWhat would you like to do (choose an option please):\n" +
          "(E) enter a new task\n" +
          "(U) update status of existing task\n" +
          "(S) print some stats\n" +
          "(Q) nothing, just quit\n")

      val input = function.toLowerCase

      input match {
        case "e" => toDo.enterNewTask()
        case "u" => toDo.updateTaskStatus()
        case "s" => statsOption()
        case "q" => toDo.quit()
        case _ => println("Please choose one of the options above!")
      }
    }
  }

  /**
   * helper function that asks user which info/stats about tasks he wants to see
   */
  def statsOption(): Unit = {
    val input2 = readLine("\nWhich stats would you like to see (choose an option please):\n" +
      "(R) show remaining tasks\n" +
      "(F) show finished tasks\n" +
      "(S) print status summary\n" +
      "(H) show 5 most urgent tasks\n" +
      "(Q) nothing, want to quit\n")

    input2 match {
      case "r" => toDo.showRemainingTasks()
      case "f" => toDo.showFinishedTasks()
      case "s" => toDo.printStats()
      case "h" => toDo.showUrgentTasks()
      case "q" => toDo.quit()
      case _ => println("Please choose one of the options above!")
    }
  }

  setup()

}
