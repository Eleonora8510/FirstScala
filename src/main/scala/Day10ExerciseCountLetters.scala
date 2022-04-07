
import scala.io.StdIn.readLine

object Day10ExerciseCountLetters extends App {
  //TODO ask user for some sentence or word
  //Count the number of characters in this string
  //Store them in a mutable Map of type Char, Int
  //print the results
  //you can count whitespace as well

  //you could store results in some sort of Sequence and then convert to Map later, but that would just complicate things

  val text = readLine("Write a word or a sentence, please: ").toString.toLowerCase

  def countWords(text: String):Map[String, Int]={
    val splittedText = text.split(" ")
    var wordLengthMap = Map[String, Int]()
    for (word <- splittedText) wordLengthMap += (word -> word.length)
    wordLengthMap
  }

  println(countWords(text))

//  val splittedText = text.split(" ")
//  //val wordLengthMap = for (word <- splittedText) yield (word, word.length).toString()
//  val wordLengths = splittedText.map(words => words.length)
//  val wordsMap = Map(splittedText.mkString(", ") -> wordLengths.mkString(", "))
//  println(wordsMap)
//  println(wordsMap.size)

  //println(wordLengthMap)

  val charCountMap = scala.collection.mutable.Map[Char, Int]()

  for (c <- text) {
    println(s"Will do smth with $c")
    //charCountMap += (c -> text.count(t=> t ==c))
    charCountMap += (c -> text.count(_ == c)) //shorter version
  }

  //  //will this work and will this be fast?
  //  println(charCountMap)
  //  //this is a solution but it is not the best solution
  //
  //  //what do you think is the problem with this solution?
  //  //the only problem is that each time we count we have to run a loop through all the text,
  //  //so we end up doing quadratic work, meaning loop withing a loop
  //
  //  //there is a better solution where we only need a single loop
  //  //think of throwing things in boxes when you organize stuff around the house
  //  //we are going to set a box for each letter and just throw the letters in

    val charCountMapToo = scala.collection.mutable.Map[Char, Int]()

    for (c <- text) {
      if (charCountMapToo.contains(c)) {
        charCountMapToo(c) += 1
      } else {
        charCountMapToo(c) = 1
      }
    }


    println(charCountMapToo)

  def countCharsByCounting(str: String):Map[Char, Int] = {
    val charCountMap = scala.collection.mutable.Map[Char, Int]()
    for (c <- text) {
      println(s"Will do smth with $c")
      //charCountMap += (c -> text.count(t=> t ==c))
      charCountMap += (c -> text.count(_ == c)) //shorter version
    }
    charCountMap.toMap //functions should return immutable structures whenever possible
  }

  def countCharsByBuckets(text:String, lower:Boolean=false):Map[Char,Int]={
    val charCountMap =scala.collection.mutable.Map[Char,Int]()
    val myText = if (lower) text.toLowerCase else text
    for (c <- myText) {
      if (charCountMap.contains(c)) {
        charCountMap(c) += 1
      } else {
        charCountMap(c) = 1
      }
    }
    charCountMap.toMap
    }

  val longText = "A quick brown fox jumped over a sleeping dog" * 1_000
  println(longText.length)

  val t0 = System.nanoTime()
  val resMap = countCharsByCounting(longText)
  val t1 = System.nanoTime()
  MyUtil.printDeltaMs(t0,t1,"Counting by actually counting each char")

  val t2 = System.nanoTime()
  val resMap2 = countCharsByBuckets(longText)
  val t3 = System.nanoTime()
  MyUtil.printDeltaMs(t2, t3, "Counting by buckets")

  val hugeText = "A quick brown fox jumped over a sleeping dog" * 1_000_000
  println(s" Huge text is ${hugeText.length} characters long")
  val t4 = System.nanoTime()
  val resMap3= countCharsByBuckets(hugeText)
  val t5 = System.nanoTime()
  MyUtil.printDeltaMs(t4, t5, "Counting by buckets huge text")
  println(resMap3)

  val t6= System.nanoTime()
  val resMap4= countCharsByBuckets(hugeText, lower=false)
  val t7 = System.nanoTime()
  MyUtil.printDeltaMs(t6, t7, "Counting by buckets huge text lower only")
  println(resMap4)

}
