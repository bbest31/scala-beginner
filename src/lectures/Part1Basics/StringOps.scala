package lectures.Part1Basics

object StringOps extends App {

    val s: String = "Hello, I am learning Scala"

    println(s.charAt(2))
    println(s.substring(0, 4))
    println(s.split(" ").toList)
    println(s.startsWith("Hello")) // true
    println(s.replace(" ", "_"))

    val strNum = "2"
    val Num = strNum.toInt
    println('a' +: strNum :+ 'z')
    println(s.reverse)
    println(s.take(2))

    // Scala-specific: String interpolators

    // S-interpolators
    val name = "Brandon"
    val age = 26
    val greeting = s"Hello, my name is $name and I am $age years old."
    val greeting2 = s"Hello, my name is $name and I will be turning ${age + 1} years old."

    println(greeting)
    println(greeting2)

    // F-interpolators is for formating strings
    val speed = 1.2F
    val myth = f"$name can eat $speed%2.2f burgers/min"
    println(myth)

    // RAW-interpolator

    println(raw"This is a \nnewline")
    val escaped = "This is a \nnewline"
    println(raw"$escaped")


}
