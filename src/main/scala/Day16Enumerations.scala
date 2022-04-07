import Fingers.Finger

object Fingers extends Enumeration {
  type Finger = Value

  val Thumb, Index, Middle, Ring, Little = Value
}

//class FingersOperation {
//  def isShortest(finger: Finger) = finger == Little
//}
//
//def twoLongest() =
//  Fingers.values.toList.filter(finger => finger == Middle || finger == Index)
//
object Day16Enumerations extends App{
  println("Let's have some fun with enumerations.")

  for (finger <- Fingers.values) println(finger.id, finger)

  def isRude(someFinger: Finger): Boolean = {
    someFinger == Fingers.Middle
  }


  println(isRude(Fingers.Thumb))
//  def givenAFinger_whenIsShortestCalled_thenCorrectValueReturned() = {
//    val operation = new FingersOperation()
//
//    assertTrue(operation.isShortest(Little))
//    assertFalse(operation.isShortest(Index))
//  }

//  def givenFingers_whenTwoLongestCalled_thenCorrectValuesReturned() = {
//    val operation = new FingersOperation()
//
//    assertEquals(List(Index, Middle), operation.twoLongest())
//  }
}

