object Booleans extends App{
  println("Helo Booleans")
  val isLate = true
  val isSunny = false

  val isMathCorrect = 2*2 == 4
  println(s"Math 2*2 == 4 looks fine: $isMathCorrect")
  val myName = "Eleonora"
  println("Is my name Eleonora", myName == "Eleonora")

  println("5>10", 5>10)

  val a = 2
  val b = 4
  println("a*a == b", a*a == b)
  println("a*a*10 != b", a*a*10 != b)

  println(0.1 + 0.2 - 0.3 == 0)
  println(Math.round(0.1 + 0.2 - 0.3) == 0)
  val myChar = 'A'
  val anotherChar = 'a'
  println(myChar == anotherChar)

  val anotherName = "Ela"
  println((myName < anotherName)) //Ela < Ele in ascii/unicode tables
}

