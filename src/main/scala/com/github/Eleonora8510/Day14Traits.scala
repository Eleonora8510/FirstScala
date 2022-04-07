package com.github.Eleonora8510

trait Read {
  val readType = "Read"
  val gender = "m"
  def read(name:String){
    println(name+" is reading")
  }
}

trait Listen {
  val listenType = "Listen"
  val gender = "m"
  def listen(name:String){
    println(name + " is listenning")
  }
}

class PersonToo() extends Read with Listen{
  override val gender = "f"
}

object Day14Traits {
  def main(args: Array[String]): Unit = {
    val person = new PersonToo()
    person.read("zhangsan")
    person.listen("lisi")
    println(person.listenType)
    println(person.readType)
    println(person.gender)

  }
}
