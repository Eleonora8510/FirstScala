import java.security.KeyStore.TrustedCertificateEntry

object First_App extends App{
    println("This is the first app")
    println("Some chcanges were made")
    val myName = "Eleonora"
    println(myName)

    var myJob = "Teacher"
    println(myJob)
    myJob = "Mum"
    println(myJob)
    val myNumber = 42

    val myPi = 3.14

    val bigNum = 2_000_000_000 // underscores are not required, just for human readability
    println(bigNum)
    println(bigNum + 500_000_000)

    println(Math.pow(2,32))

    val myLongVal = 8_000_000_000L
    println(myLongVal)
    println(Math.pow(2,63)) //limit for long numbers

    val isLate = true // boolean
    val isTired = false

    println(myName.getClass, myNumber.getClass, myPi.getClass, myLongVal.getClass,isLate.getClass)



}


