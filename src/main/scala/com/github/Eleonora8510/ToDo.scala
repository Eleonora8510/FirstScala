package com.github.Eleonora8510

import scala.io.StdIn.readLine


case class Task(id: Int, task: String, created:String,  deadline:String, status:String) {
  def getPrettyString: String = s"ID: $id, task: $task, created: $created, status: $status, deadline: $deadline"
}

case class Status (status: String, numberOfTasks: Int) {
  def statusPrettyPrint: String = s"There are $numberOfTasks tasks with status $status"
}


class ToDo (){

  val db = new ToDoDB("src/resources/todo/todo.db")

  /**
   * gets the information about task (task, status, deadline) and enter to the database
   */
  def enterNewTask():Unit = {
    val task = readLine("Enter the task: ")
    var deadline = readLine("Enter the deadline (ENTER to skip): (yyyy-MM-dd)")

    while (!getDate(deadline)) {
        deadline = readLine("Enter the deadline (ENTER to skip): (yyyy-MM-dd)")
    }

    val status = "created"
    println(s"New ToDo is created: $task, deadline: $deadline")
    db.insertTask(task, deadline, status)
  }

  /**
   *
   * @param deadline
   * @returns true if the inserted date has correct format or if it is skipped and
   * returns false if date has wrong format
   */
  def getDate(deadline: String):Boolean = {

    val yearInserted = getYearMonthDayRegEx(deadline)._1
    val boolean = getYearMonthDayRegEx(deadline)._4

    yearInserted match{
      case "N/A" => println("No deadline inserted")
      case "NO YEAR" => println("Wrong format of deadline")
      case _ => println()
    }

    boolean

  }

  /**
   *
   * @param dateString - deadline inserted together with task
   * @returns year, month and day of the deadline and true if it is correct or
   * returns appropriate messages and false if it isn't correct
   */
  def getYearMonthDayRegEx(dateString: String): (String, String, String, Boolean) = {
    val dateRegEx = raw"(\d){4}\D(\d){2}\D(\d){2}".r
    dateString match {
      case dateRegEx(year, month, day) => (year, month, day, true)
      case "" =>("N/A", "N/A", "N/A", true)
      case _ => ("NO YEAR", "NO MONTH", "NO DAY", false)
    }
  }

  /**
   * returns the pretty print of remaining tasks
   */
  def showRemainingTasks(): Unit = {
    val remainingTasks = db.getRemainingTasks
    if (remainingTasks.length == 0) println("No tasks in database!")
    else {
      println("Remaining tasks are:")
      remainingTasks.foreach(task => println(task.getPrettyString))
    }
  }

  /**
   * returns the pretty print of finished tasks
   */
  def showFinishedTasks(): Unit = {
    val finishedTasks = db.getFinishedTasks()
    if (finishedTasks.length == 0) println(s"Go forward! You do not have tasks completed")
    else {
      println("Finished tasks are:")
      finishedTasks.foreach(task => println(task.getPrettyString))
      println("Keep up the good work")
    }
  }

  /**
   * deletes finished tasks by applying to SQL query
   */
  def deleteFinishedTasks(): Unit = {
    println("Deleting finished tasks")
    db.deleteFinishedTasks
  }

  /**
   *
   * @returns updated status in DB
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

  /**
   * returns print of stats of different statuses
   */
  def printStats(): Unit = {
    val result = db.getStatsDB
    result.foreach(status => println(status.statusPrettyPrint))
  }

  /**
   * returns print of most urgent tasks
   */
  def showUrgentTasks(): Unit = {
    val urgentTasks = db.sortTaskByDate
    println("5 most urgent tasks are:\n")
    urgentTasks.foreach(task => println(task.getPrettyString))

  }

  /**
   * drops table (tasks)
   */
  def dropTables(): Unit = {
    db.dropAllTables()
  }

  /**
   * leaves the main loop
   */
  def quit(): Unit = {
    FinalProject_ToDo_List.userIsActive = false
    println("All is done! See you next time :)")

  }



}
