package com.github.Eleonora8510

import scala.xml.{Node, XML}

object Day22ParsingXML extends App {
  val src = "src/resources/xml/books.xml"

  val xml = XML.loadFile(src)

  println(xml)

  //in Scala 2 i can still make XML directly, - XML is a first class citizen
  val myOwnXMl = <book id="bk305">
    <title>Best Fruit Cocktails
    </title>
    <author>Doe, John
    </author>
  </book>

  println(myOwnXMl)

  val books = xml \ "book" //i am saying get all book tags that are direct children of this xml element(catalog here)

  val firstBook = books.head
  println(firstBook)

  println(firstBook \ "author") // printing with tags

  //we can get the contents of some attribute considering the fact that the atribute might not exist at all
  val id = firstBook.attribute("id").getOrElse("bk0").toString
  println(s"Our book id is $id")

  println((firstBook \ "author").text)
  println((firstBook \ "title").text)
  println((firstBook \ "genre").text)
  println((firstBook \ "price").text)

  def getBook(node: Node): BookUnit = {
    val id = node.attribute("id").getOrElse("bk0").toString
    val author = (node \ "author").text
    val title = (node \ "title").text
    val genre = (node \ "genre").text
    val price = (node \ "price").text.toDouble
    val publish_date = (node\ "publish_date").text
    val description = (node \ "description").text
    BookUnit(id, author, title, genre, price, publish_date, description)
  }

  val bookUnits = (for (book <- books) yield getBook(book)).toArray

  println(bookUnits.head)
  println(bookUnits.last)

  val genres = bookUnits.map(_.genre).distinct
  println(genres.mkString(","))

  println("\n")

  //TODO find the 5 most expensive books
  val expensiveBooks = bookUnits.sortBy(_.price).reverse
  println(s"The most expensive books:")
  expensiveBooks.take(5).foreach(_.prettyPrint())
  println("\n")

  //TODO find the 5 cheapest books
  val cheapBooks = bookUnits.sortBy(_.price)
  println(s"The cheapest books:")
  cheapBooks.take(5).foreach(_.prettyPrint())
  println("\n")

  //TODO find all romance books
  val romanceBooks = bookUnits.filter(_.genre == "Romance")
  println(s"Romance books:")
  romanceBooks.foreach(_.prettyPrint())
  println("\n")

  //TODO get all distinct authors in alphabetical order
  val authors = bookUnits.map(_.author).distinct.sorted
  println("Authors:\n")
  println(authors.mkString("\n"))

}
