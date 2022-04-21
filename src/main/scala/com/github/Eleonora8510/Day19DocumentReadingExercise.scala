package com.github.Eleonora8510


import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

class Document(title: String = "", author: String = "", url: String = "", rows: Array[String] = Array[String]()) {
  val rowCount: Int = rows.length
  val wordCount: Int = Util.getWordCountPerLine(rows).sum

  def save(dst: String = "", folder: String = "src/resources/texts"): Unit = {
    def getLinesFromWeb(url: String): Array[String] = {
      val html = Source.fromURL(url)
      val lines = html.getLines().toArray
      html.close()
      lines
    }

    var lines: Array[String] = Array[String]()
    if (rowCount == 0) {
      lines = getLinesFromWeb(url)
    } else {
      lines = rows
    }

    var bookTitle = " "
    if (title =="") {
      bookTitle = GutenbergUtil.getTitle(lines)
    } else bookTitle = title

    var  bookAuthor = " "
    if (author == "") {
      bookAuthor = GutenbergUtil.getAuthor(lines)
    } else bookAuthor = author


    // creating new name for file
    def nameForFile(dst: String = dst, author: String = bookAuthor, title: String = bookTitle): String = {
      var new_dst = " "
      if ((dst == " ") && (author != " ") || (title != " ")) {
        val slicingIndexForAuthor = bookAuthor.indexOf(' ') + 1
        val authorSurname = author.slice(slicingIndexForAuthor, slicingIndexForAuthor + 10).replace(' ', '_')

        val titleLine = title.take(15).replace(' ', '_')

        val ts = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm").format(LocalDateTime.now)

        new_dst = authorSurname + "_" + titleLine + "_" + ts
        new_dst
      } else {
        if ((dst == " ") && author.contains("AUTHOR")) {
          new_dst = url.take(25)
          new_dst
        } else {
          new_dst = dst
          new_dst
        }
      }
    }

    // new filePath for book text
    val newNameForFile = nameForFile()
    val textFilePath = folder + "/" + newNameForFile + ".txt"
    println(textFilePath)

    // text to be saved in new file
    val text = "URL: " + url + "\n" + "Author: " + bookAuthor + "\n" + "Title: " + bookTitle + "\n" * 3
    // saving text to text file
    Util.saveText(textFilePath, text, append = true)
    Util.saveLines(textFilePath, lines, append = true)

  }
}

object Day19DocumentReadingExercise extends App{
  println("\nNew books are going to be saved into computer directory\n")

  // checking for command arguments
  var filePath = ""
  if (args.length == 0) {
    filePath = "src/resources/webPages.txt"
  } else {
    filePath = args(0)
  }

  println(s"File path for document with urls: $filePath \n")

  // reading urls from file
  val urls = Util.getLinesFromFile(filePath)

  //saving urls into the array and adding https:// when needed
  var urlArray = new ArrayBuffer[String](10)
  val urlPrefix = "https://"
  for (line <-urls) {
    if (line.contains("https://") || line.contains("http://")) urlArray += line
    else urlArray += urlPrefix.concat(line)
  }

println(urlArray)

  // calling save method
  for (urlLine <- urlArray) {
    new Document(url=urlLine).save()
    Thread.sleep(200)
  }

  // checking utility of Document class when having title, author and rows
  val myBook = Util.getLinesFromFile("src/resources/ChristieA_Poirot_Investigates.txt")
  new Document(title="Poirot Investigates", "Agatha Christie", rows = myBook).save()

}
