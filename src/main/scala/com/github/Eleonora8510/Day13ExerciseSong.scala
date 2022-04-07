package com.github.Eleonora8510

class Song(title: String = "", author: String= "", lyrics:Array[String]) {
  println(s"New song $title made by $author")
  println(s"The song has ${lyrics.length} lines")

  def sing(maxLines: Int = -1):Unit = {
    println("*"*50)
    println(s"$author '$title'")
    println("*"*50)

    if ((maxLines == -1) || (maxLines > lyrics.length)){
      lyrics.foreach(line => println(line))
    } else {
      lyrics.take(maxLines).foreach(line => println(line))
    }
  }

  def yell(maxLines: Int = -1):Unit = {
    println("*"*50)
    println(s"${author.toUpperCase} '${title.toUpperCase}'")
    println("*"*50)

    if ((maxLines == -1) || (maxLines > lyrics.length)){
      lyrics.foreach(line => println(line.toUpperCase))
    } else {
      lyrics.take(maxLines).foreach(line => println(line.toUpperCase))
    }
  }

}

class Rap(val title: String = "", val author: String= "", val lyrics:Array[String], maxLines:Int = -1, drop: String = "YEAH")
  extends Song(title: String, author: String, lyrics:Array[String]) {
  def breakIt():Unit = {
    println("*"*50)
    println(s"com.github.Eleonora8510.Rap of $author '$title' ")
    println("*"*50)

    if ((maxLines == -1)||(maxLines > lyrics.length)){
      for (line <- lyrics) {
        print(line.replace(" ", " "+drop+" "))
        println(s" $drop") // at the end of line
      }
    } else {
        for (line <- lyrics.take(maxLines)) {
          print(line.replace(" ", " "+drop+" "))
          println(s" $drop") // at the end of line
        }
        }
    }

  }


object Day13ExerciseSong extends App {
  println("Let's make some song")

  val lambada = new Song("Lambada",
    "Kaoma",
    Array("Chorando se foi quem um dia só me fez chorar",
      "Chorando se foi quem um dia só me fez chorar",
      "Chorando estara ao lembrar de um amor",
      "Que um dia não soube cuidar",
      "Chorando estará ao lembrar de um amor",
      "Que um dia não soube cuidar",
      "A recordação vai estar com ele aonde for",
      "A recordação vai estar pra sempre aonde for"))
  lambada.sing(3)
  lambada.yell(4)

  val littleStar = new Song("Twinkle twinkle little star",
    "Jane Taylor",
    Array("Twinkle twinkle little star",
      "How I wonder what you are",
      "Up above the world so high",
      "Like a diamond in the sky"))

  littleStar.sing(-1)
  littleStar.yell(1)

  val rapBlackbird = new Rap("Blackbird",
    "The Beatles",
    Array("Blackbird singing in the dead of night",
    "Take this broken wings and learn to fly",
    "All your life",
    "You were only waiting for this moment to arise"), -1, "YAH")

  rapBlackbird.yell(3)
  rapBlackbird.breakIt

}