
trait FlightTrait {
  def fly():Unit
}

trait RunningTrait {
  def run(speed: Double):Unit
  def race(yesOrNo: Char = 'Y'):Unit
  def jump(yesOrNo: Char = 'Y'):Unit
}

trait SwimmingTrait {
  def swim():Unit
}

abstract class Bird extends FlightTrait with RunningTrait with SwimmingTrait

class Penguin extends Bird{
  def fly(): Unit = println("Not flying")
  def run(speed: Double = 7):Unit = println(s"Able to run $speed km per h")
  def race(yesOrNo: Char):Unit = {
    if (yesOrNo == 'Y') {
      println("Able to race")
    } else {
      println("Doesn't like racing")
    }
  }
  def jump(yesOrNo: Char = 'Y'):Unit= {
    if (yesOrNo == 'Y') {
      println("Able to jump")
    } else {
      println("Doesn't like jumping")
    }
  }
    def swim():Unit=println("Able to swim")
}

class Chicken extends Bird{
  def fly(): Unit = println("Trying to fly")
  def run(speed: Double = 0.5):Unit = println(s"Able to run $speed km per h")
  def race(yesOrNo: Char):Unit = {
    if (yesOrNo == 'Y') {
      println("Able to race")
    } else {
      println("Doesn't like racing")
    }
  }
  def jump(yesOrNo: Char = 'Y'):Unit= {
    if (yesOrNo == 'Y') {
      println("Able to jump")
    } else {
      println("Doesn't like jumping")
    }
  }
  def swim():Unit=println("Not practicing swimming")
}

object Day14ExerciseBirds extends App {
  println("Let's create some birds using traits!")

  println("\nWhat about penguins?")

  val pingo = new Penguin()
  pingo.swim()
  pingo.race('N')

  val pengie = new Penguin
  pengie.jump('N')
  pengie.fly()

  println("\nHow about chicken?")

  val chicky = new Chicken()
  chicky.run(0.1)

  val chickie = new Chicken()
  chickie.jump()
  chickie.fly()

}

