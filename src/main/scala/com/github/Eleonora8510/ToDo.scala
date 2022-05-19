package com.github.Eleonora8510

import com.github.Eleonora8510.FinalProject_TODO_List.db

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.io.StdIn.readLine

case class Task(task: String, created:String,  deadline:String, status:String) {
  def getPrettyString: String = s"Task: $task, created: $created, status: $status, deadline: $deadline"
}

class ToDo (task: String,
            created: String =  DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm").format(LocalDateTime.now),
            status: String = "created",
            deadline: String){

  /**
   * inserts the information about task: task, status, deadline
   */
  val db = new ToDoDB("src/resources/todo/todo.db")

  def enterNewTask():Unit = {
    val task = readLine("Enter the task: ")
    // TODO check if the deadline is not earlier than current time
    val deadline = readLine("Enter the deadline: (yyyy-MM-dd HH:mm)")
    val status = "created"
    //val newTask = new Tasks(task = task, status = status, deadline = deadline)

    ///newTask.prettyPrint()
    db.insertTask(task, deadline, status)

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

  }

  def showRemainingTasks(): Unit = {
    println("Remaining tasks are:")
    val remainingTasks = db.getRemainingTasks
    //val allPlayers = getFullPlayerInfo()
    remainingTasks.foreach(task => println(task.getPrettyString))

  }

  //TODO add checking if there are any tasks inserted in database(table tasks)


}
