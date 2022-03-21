import scala.io.StdIn.readLine

object Day8CubeSequence extends App{
    //TODO ask user for starting number
    //TODO ask user for ending numbers
    //Calculate cubes of these integers including start and end AND store results in a sequence
    //Print the saved sequence on screen

    //extra challenge save odd cubes and print them

    val startingNumber = readLine("Enter the starting number, please \n").toInt
    val endingNumber = readLine("Enter the ending number, please \n").toInt

    if (startingNumber > endingNumber) println("The starting number should be less than the ending number")
    else {
      val cubes = for (number <- startingNumber to endingNumber) yield Math.pow(number, 3).toInt
      println(s"The cubes are: $cubes")
     val oddCubes = for (number <- cubes if number % 2==1) yield number
     println(s"Odd cubes $oddCubes")
    }

}


