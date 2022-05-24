package com.github.Eleonora8510.FinalAssignment

import java.nio.file.{Files, Paths}

object ToToDBCon extends App{
  // create directory
  val dstFolder = "src/resources/todo"
  Files.createDirectories(Paths.get(dstFolder))

  // create DB
  val db = new ToDoDB("src/resources/todo/todo.db")

  // create tables in DB

  db.migrate()

  //cleanup
  db.conn.close()

}
