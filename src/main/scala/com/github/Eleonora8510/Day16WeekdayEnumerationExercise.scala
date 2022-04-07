package com.github.Eleonora8510

import com.github.Eleonora8510.Weekdays.Weekday

object Weekdays extends Enumeration {
  type Weekday = Value

  val Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday = Value
}

object Day16WeekdayEnumerationExercise extends App{

  def isWeekend(someDay: Weekday): Boolean = {
    (someDay == Weekdays.Sunday) || (someDay ==Weekdays.Saturday)
  }


  println(s"Is Monday the weekend? ${isWeekend(Weekdays.Monday)}")
  println(isWeekend(Weekdays.Sunday))

}
