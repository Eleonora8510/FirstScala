package com.github.Eleonora8510

import java.nio.file.{Files, Paths}
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.io.StdIn.readLine

object FinalProject_TODO_List extends App{
  println("Hello!\nThis is Task List Manager")
  var userIsActive = true

  val dstFolder = "src/resources/todo"
  Files.createDirectories(Paths.get(dstFolder))

  // create DB
  val db = new ToDoDB("src/resources/todo/todo.db")
  val toDo = new ToDo("", "","","") //TODO check if ToDo class needs parameters

//  // create tables in DB
  db.migrate()

  /**
   * main loop
   */
  def setup(): Unit = {
    while (userIsActive) {
      val function = readLine("What do you want to do (choose the appropriate letter):\n" +
        "(E) enter a new task\n" +
        "(U) update status of existing\n" +
        "(R) show remaining tasks\n" +
        "(D) delete task\n" +
        "(Q) quit\n")

      if (function.toLowerCase.startsWith("e")) {
        toDo.enterNewTask()
      }
      else if (function.toLowerCase.startsWith("u")) {
        val newStatus = toDo.updateTaskStatus()
        db.insertNewStatus(newStatus)
      }
      else if (function.toLowerCase.startsWith("r")) {
        toDo.showRemainingTasks()
      }
      else {
        toDo.quit()
        userIsActive = false
      }
    }
}


  setup()
  db.conn.close()


}
