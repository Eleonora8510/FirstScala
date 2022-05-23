package com.github.Eleonora8510

import scala.io.StdIn.readLine


case class Task(id: Int, task: String, created:String,  deadline:String, status:String) {
  def getPrettyString: String = s"ID: $id, task: $task, created: $created, status: $status, deadline: $deadline"
}

case class Status (status: String, numberOfTasks: Int) {
  def statusPrettyPrint: String = s"There are $numberOfTasks tasks with status $status"
}


class ToDo (){

  /**
   * insert the information about task: task, status, deadline
   */
  val db = new ToDoDB("src/resources/todo/todo.db")

  def enterNewTask():Unit = {
    val task = readLine("Enter the task: ")
    var deadline = readLine("Enter the deadline (ENTER to skip): (yyyy-MM-dd HH:mm)")

    while (!getDate(deadline))
      deadline = readLine("Enter the deadline (ENTER to skip): (yyyy-MM-dd HH:mm)")

    val status = "created"
    println(s"New ToDo is created: $task, deadline: $deadline")
    db.insertTask(task, deadline, status)
  }

  def getDate(deadline: String):Boolean = {

    val yearInserted = getYearMonthDayRegEx(deadline)._1
    val boolean = getYearMonthDayRegEx(deadline)._6

    yearInserted match{
      case "N/A" => println("No deadline inserted")
      case "NO YEAR" => println("Wrong format of deadline")
      case _ => println()
    }

    boolean

  }

  def getYearMonthDayRegEx(dateString: String): (String, String, String, String, String, Boolean) = {
    val dateRegEx = raw"(\d){4}\D(\d){2}\D(\d){2}\D(\d){1,2}\D(\d){2}".r
    dateString match {
      case dateRegEx(year, month, day, hours, minutes) => (year, month, day, hours, minutes, true)
      case "" =>("N/A", "N/A", "N/A", "N/A","N/A", true)
      case _ => ("NO YEAR", "NO MONTH", "NO DAY", "NO HOURS", "NO MINUTES", false)
    }
  }

  def showRemainingTasks(): Unit = {
    val remainingTasks = db.getRemainingTasks
    if (remainingTasks.length == 0) println("No tasks in database!")
    else {
      println("Remaining tasks are:")
      remainingTasks.foreach(task => println(task.getPrettyString))
    }
  }

  def showFinishedTasks(): Unit = {
    val finishedTasks = db.getFinishedTasks()
    if (finishedTasks.length == 0) println(s"Go forward! You do not have tasks completed")
    else {
      println("Finished tasks are:")
      finishedTasks.foreach(task => println(task.getPrettyString))
      println("Keep up the good work")
    }
  }

  def deleteFinishedTasks(): Unit = {
    println("Deleting finished tasks")
    db.deleteFinishedTasks
  }

  /**
   *
   * @return updated status in DB
   */
  def updateTaskStatus(): Unit = {
    //need to show task list, so:
    showRemainingTasks()

    val chosenTask = readLine("Please enter the ID of the task to be updated:").toInt

    var updatedStatus = readLine("Choose the status:\n" +
      "(C) created\n" +
      "(P) in progress\n" +
      "(F) finished")

    if (updatedStatus.toLowerCase.startsWith("c")) updatedStatus = "created"
    else if (updatedStatus.toLowerCase.startsWith("p")) updatedStatus = "in progress"
    else updatedStatus = "finished"

    println(s"Great, task with ID $chosenTask was updated. New status is $updatedStatus")

    db.updateTaskStatusDB(chosenTask, updatedStatus)

  }

  def printStats(): Unit = {
    val result = db.getStatsDB
    result.foreach(status => println(status.statusPrettyPrint))
  }

  def showUrgentTasks(): Unit = {
    val urgentTasks = db.sortTaskByDate
    println("5 most urgent tasks are:\n")
    urgentTasks.foreach(task => println(task.getPrettyString))

  }


  /**
   * leave the main loop
   */
  def quit(): Unit = {
    FinalProject_ToDo_List.userIsActive = false
    println("All is done! See you next time :)")

  }

}
