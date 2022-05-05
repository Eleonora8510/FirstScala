package com.github.Eleonora8510

import java.sql.DriverManager
import scala.collection.mutable.ArrayBuffer

case class Album(AlbumId : Int, Title : String, ArtistId : Int)

case class Tracks(TrackId : Int,
                  Name : String,
                  AlbumId : Int,
                  MediaTypeId: Int,
                  GenreId : Int,
                  Composer : String,
                  Milliseconds : Int,
                  Bytes : Int,
                  UnitPrice: Double){
  override def toString()=s"$TrackId, $Name, $AlbumId, $MediaTypeId, $GenreId, $Composer, $Milliseconds, $Bytes, $UnitPrice"
}

object Day25Exercise extends App{

  val dbPath = "src/resources/db/chinook.db"
  val url = s"jdbc:sqlite:$dbPath"

  println(s"Will connect SQLite database at the following url:  $url")
  println("Connection to Albums table\n")

  val conn = DriverManager.getConnection(url)

  val statement = conn.createStatement()

  //TODO Create Album Case Class with appropriate data types for each field
  //TODO connect to chinook and extract into Array of Album (using ArrayBuffer to build it up)

  val sqlAlbum =
    """
      |SELECT * FROM albums;
      |""".stripMargin

  val resultSet = statement.executeQuery(sqlAlbum)
  val metaData = resultSet.getMetaData
  println(s"We have received ${metaData.getColumnCount} columns")

  val albumBuffer = ArrayBuffer[Album]()

  while (resultSet.next()) {

    val album = Album(resultSet.getInt("AlbumId"),
      resultSet.getString("Title"),
      resultSet.getInt("ArtistId"))

    albumBuffer += album
  }


  val albumCollection = albumBuffer.toArray
  albumCollection.take(10).foreach(println)

  //TODO Create Track Case Class
  //TODO connect to database and extract into Array of Tracks -

  println()
  println("Connection to Tracks table\n")

  val sqlTracks =
    """
      |SELECT * FROM tracks;
      |""".stripMargin

  val resultSetTracks = statement.executeQuery(sqlTracks)
  val metaDataTracks = resultSetTracks.getMetaData
  println(s"We have received ${metaDataTracks.getColumnCount} columns")

  val tracksBuffer = ArrayBuffer[Tracks]()

  while (resultSetTracks.next()) {

    val tracks = Tracks(resultSetTracks.getInt("TrackId"),
      resultSetTracks.getString("Name"),
      resultSetTracks.getInt("AlbumId"),
      resultSetTracks.getInt("MediaTypeId"),
      resultSetTracks.getInt("GenreId"),
      resultSetTracks.getString("Composer"),
      resultSetTracks.getInt("Milliseconds"),
      resultSetTracks.getInt("Bytes"),
      resultSetTracks.getDouble("UnitPrice"))

    tracksBuffer += tracks
  }
  conn.close()

  val tracksCollection = tracksBuffer.toArray
  tracksCollection.take(10).foreach(println)

  //Extra Challenge
  //TODO save all Tracks into CSV - in src/resources/csv/tracks.csv -
  // results should be very similar or identical to what you get in DBeaver export CSV - tracks_exported.csv
  //Check Day 20 examples on how we did this

  val fileName = "tracks_exported.csv"
  val folderName = "src/resources/csv"
  val dst = s"$folderName/$fileName" // type String
  println(s"Will save in $dst")

  val tracksStrings = tracksCollection.map(_.toString)
  val newCSVFile = Util.saveLines(dst, tracksStrings, append = true)
  //val columnNames = Array("TrackId", "Name", "AlbumId", "MediaTypeId", "GenreId", "Composer", "Milliseconds", "Bytes", "UnitPrice")



}
