object Day5FizzBuzzExercise extends App {
  val numberOne: Int = 5
  val numberTwo: Int = 7

  for (i <- 1 to  100) {
     if (i % numberOne == 0 && i % numberTwo == 0) println("FizzBuzz")
     else if (i % numberOne == 0) println("Fizz")
     else if (i % numberTwo == 0) println("Buzz")
     else println(i)
   }

  }

