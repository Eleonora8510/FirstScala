import scala.io.StdIn.readLine

object TreesAssignment extends App {

  val userName = readLine("Could you enter your name, please? ")
  val treeHeight = readLine("Could you enter the number not greater than 40? ").toInt

  def printTree(name:String, height:Int, symbol:Char='*', maximumHeight:Int=40):Unit = {

    def stringToPrint(nameString:String, height:Int):String = {
      var charsToPrint = "*"
      val nameLength = nameString.length

      if (nameLength >= height) {
        charsToPrint += nameString.substring(0, height-1).toUpperCase
        charsToPrint
      }
      else {
        val wholePart = Math.round(height / nameLength)
        val reminder = height % nameLength
        charsToPrint += (nameString * wholePart + nameString.substring(0, reminder - 1)).toUpperCase
        charsToPrint
      }
    }

    val a_MaxH = 1 + (maximumHeight -1)*2
    var middleIndex = Math.round(a_MaxH / 2)
    var multiplier = 1

    for (c<-stringToPrint(name, height)) {
      println(" " * middleIndex + s"$c" * multiplier + " " * middleIndex)

      middleIndex -= 1
      multiplier += 2
    }
  }

  printTree(userName, treeHeight)
}