package com.github.Eleonora8510

case class BookUnit(id: String,
                    author: String,
                    title: String,
                    genre: String,
                    price: Double,
                    publish_date: String,
                    description: String) {
  def prettyPrint(): Unit = {
    println(s"Book id: $id, author: $author, title: $title, genre: $genre, " +
      s"price: $price, publish_date: $publish_date, description:  $description")
  }

}
