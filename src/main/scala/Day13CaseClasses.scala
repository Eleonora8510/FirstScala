object Day13CaseClasses extends App{
  println("Using case classes")
  val me = Person("Eleonora", "myself", 180) // for case classes new is not needed
  val sunflower = new Flower("sunflower","yellow")
  //val anotherFlower = sunflower.clone()
  println(me)
  // we also gain ability to pattern match by using case classes but about that later
  println(sunflower)
  // I have get access to all parameters
  val myCopy = me.copy()
  println(me.name)
  println(me.relation)
  println(me.topSpeed)
  val myNewSpeed = me.increaseSpeed(15) // we can extract the value as well
  println(myNewSpeed)
  println(s"Hello, my name ${me.name} related ${me.relation} with a top speed of ${me.topSpeed}")
  println()
  println(me == myCopy) /// so our contents are equal, but the objects are different

  val ede = Person("Ede", "daughter", 300)
  println(ede)
 // ede.name = "Valdis" // not possible since properties in case class are val by default
  ede.topSpeed = 400 // fine to mutate since I specified var in case class definition
  println(ede)


  // so mostly case classes are all about convenience
  // often a case class instance (object)  will correspond an entry/row in a database, table etc.



}
