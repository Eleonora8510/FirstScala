package com.github.Eleonora8510

abstract class Notification // this type of class can not be used directly it has to be extended

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification

case class WhatsUpMessage(contact: String, message: String, number: Int) extends Notification





object Day15CaseClassPatternMatching extends App {

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(sender, title, _) =>
        s"You got an email from $sender with title: $title"
      case SMS(number, message) =>
        s"You got an com.github.Eleonora8510.SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"You received a Voice Recording from $name! Click the link to hear it: $link"
      case WhatsUpMessage(name, msg, number) => s"You've got a WhatsUp Message: $msg with $name from number $number"
      case default => s"Unknown notification ${default.toString}"
    }
  }

  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
  val someWhatsUpMessage = WhatsUpMessage("Liga", "Come to super", 1234)
  println(showNotification(someSms))  // prints You got an com.github.Eleonora8510.SMS from 12345! Message: Are you there?

  println(showNotification(someVoiceRecording))  // prints You received a Voice Re
}
