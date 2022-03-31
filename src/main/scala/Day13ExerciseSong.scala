class Song(title: String = "", author: String= "", lyrics:Seq[String]){
  def start(title:String, author:String):Unit={
    println(s"New song $title made by $author")
  }

  def sing(title: String = "", author:String="", lyrics:Seq[String]):Unit={
    println(s"$title, Author: $author")
    for (s<-lyrics) println(s)

  }
}

object Day13ExerciseSong extends App{
  println("Let's make some song")

  val lambada = new Song("Lambada", "Kaoma", Seq("Chorando se foi quem um dia só me fez chorar", "Chorando se foi quem um dia só me fez chorar", "Chorando estara ao lembrar de um amor", "Que um dia não soube cuidar", "Chorando estará ao lembrar de um amor", "Que um dia não soube cuidar", "A recordação vai estar com ele aonde for", "A recordação vai estar pra sempre aonde for"))
  lambada.start("Lambada", "Kaoma")
  lambada.sing("Lambada", "Kaoma", Seq("Chorando se foi quem um dia só me fez chorar", "Chorando se foi quem um dia só me fez chorar", "Chorando estara ao lembrar de um amor", "Que um dia não soube cuidar", "Chorando estará ao lembrar de um amor", "Que um dia não soube cuidar"))
}
