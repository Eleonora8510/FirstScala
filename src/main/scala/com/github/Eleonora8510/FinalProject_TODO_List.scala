package com.github.Eleonora8510

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.io.StdIn.readLine

class Tasks(id: Int,
            task: String,
            created: String =  DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm").format(LocalDateTime.now),
            status: String,
            deadline: String) {

  def prettyPrint(): Unit = {
    println(s"id: $id, task: $task, created: $created, status: $status, deadline: $deadline")
  }
}

object FinalProject_TODO_List extends App{
  println("Hello!\nThis is Task List Manager")

  def enterNewTask():Unit = {
    val task = readLine("Enter the task: ")
    val status = "created"
    // TODO check if the deadline is not not earlier than current time
    val deadline = readLine("Enter the deadline: (yyyy-MM-dd_HH:mm)")

    //TODO looping id

    val newTask = new Tasks(id = 1, task = task, status = status, deadline = deadline)

    newTask.prettyPrint()

  }

  def updateTaskStatus(): Unit = {



  }

  def showRemainingTasks(): Unit = {

  }

  //TODO add checking if there are any tasks inserted in database(table tasks)
  val function = readLine("What do you want to do:\n" +
    "(E) enter a new task\n" +
    "(U) update status of existing\n" +
    "(R) show remaining tasks\n" +
    "(D) delete task\n" +
    "(Q) quit\n")


  if (function.toLowerCase.startsWith("e")) enterNewTask
  else if (function.toLowerCase.startsWith("u")) updateTaskStatus
  else if (function.toLowerCase.startsWith("r")) showRemainingTasks




}
