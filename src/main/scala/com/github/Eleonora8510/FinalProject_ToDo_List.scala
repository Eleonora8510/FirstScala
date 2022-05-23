package com.github.Eleonora8510

import java.nio.file.{Files, Paths}
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.io.StdIn.readLine

object FinalProject_ToDo_List extends App{
  println("Hello!\nThis is Task List Manager")
  var userIsActive = true

  val toDo = new ToDo()

//  // create tables in DB
  //db.migrate()

  /**
   * main loop
   */
  def setup(): Unit = {
    while (userIsActive) {
      val function = readLine("What do you want to do (choose the appropriate letter):\n" +
        "(E) enter a new task\n" +
        "(U) update status of existing task\n" +
        "(R) show remaining tasks\n" +
        "(F) show finished tasks\n" +
        "(D) delete finished tasks\n" +
        "(S) print some stats\n" +
        "(H) show 5 the most urgent tasks" +
        "(Q) quit\n")

      val input = function.toLowerCase

      input match {
        case "e" => toDo.enterNewTask()
        case "u" => toDo.updateTaskStatus()
        case "r" => toDo.showRemainingTasks()
        case "f" => toDo.showFinishedTasks()
        case "d" => toDo.deleteFinishedTasks()
        case "s" => toDo.printStats()
        case "h" => toDo.showUrgentTasks()
        case "q" => toDo.quit()
        case _ => println("Please choose one of the options above!")
      }
    }
}

  setup()

}
