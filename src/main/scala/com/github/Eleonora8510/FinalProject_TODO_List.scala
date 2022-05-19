package com.github.Eleonora8510

import java.nio.file.{Files, Paths}
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.io.StdIn.readLine

class Tasks(task: String,
            created: String =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now),
            status: String,
            deadline: String) {

  def prettyPrint(): Unit = {
    println(s"task: $task, created: $created, status: $status, deadline: $deadline")
  }
}

object FinalProject_TODO_List extends App{
  println("Hello!\nThis is Task List Manager")
  var userIsActive = true

  val dstFolder = "src/resources/todo"
  Files.createDirectories(Paths.get(dstFolder))

  // create DB
  val db = new ToDoDB("src/resources/todo/todo.db")

//  // create tables in DB
  db.migrate()


  /**
   * return the information about task: task, status, deadline
   */
  def enterNewTask():(String, String, String) = {
    val task = readLine("Enter the task: ")
    // TODO check if the deadline is not earlier than current time
    val deadline = readLine("Enter the deadline: (yyyy-MM-dd HH:mm)")
    val status = "created"
    //val newTask = new Tasks(task = task, status = status, deadline = deadline)

    ///newTask.prettyPrint()
    (task, deadline, status)

  }

  /**
   *
   * @return updated status
   */
  def updateTaskStatus(): String = {
    val newStatus = readLine("Choose the status:\n" +
      "(C) created\n" +
      "(P) in progress\n" +
      "(F) finished\n")

    var updatedStatus = ""

    if (newStatus.toLowerCase.startsWith("c")) updatedStatus = "created"
    else if (newStatus.toLowerCase.startsWith("p")) updatedStatus = "in progress"
    else updatedStatus = "finished"
    updatedStatus


  }

  /**
   * leave the main loop
   */
  def quit(): Unit = {
    println("All is done! See you next time.")
    userIsActive = false

  }

  def showRemainingTasks(): Unit = {

  }

  //TODO add checking if there are any tasks inserted in database(table tasks)

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
        val tasksToInsert = enterNewTask
        db.insertTask(tasksToInsert._1, tasksToInsert._2, tasksToInsert._3)
        userIsActive = true
      }
      else if (function.toLowerCase.startsWith("u")) {
        val newStatus = updateTaskStatus
        db.insertNewStatus(newStatus)
        userIsActive = true
      }
      else {
        quit
        userIsActive = false
      }
    }
}


  setup()
  db.conn.close()


}
