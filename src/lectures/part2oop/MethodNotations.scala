package lectures.part2oop

object MethodNotations extends App {

    class Person(val name: String, favoriteMovie: String) {
        def likes(movie: String): Boolean = movie == favoriteMovie
        def hangoutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
        def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
        def unary_! : String = s"$name, what the heck?"
        def isAlive : Boolean = true
        def apply() : String = s"Hi, my name is $name and I like $favoriteMovie"
    }

    val mary = new Person("Mary", "Inception")
    println(mary.likes("Inception"))
    println(mary likes "Inception") //infix notation

    // "operators" in Scala
    val tom = new Person("Tom", "Fight Club")
    println(mary hangoutWith tom)
    println(mary + tom) // in Scala we can use traditional operators as method signatures


    // Pre-fix notation
    val x = -1 // == 1.unary_-
    val y = 1.unary_-
    // works with - + ~ !

    println(!mary)
    println(mary.unary_!)

    // Post-fix notation
    println(mary.isAlive)
    println(mary isAlive)

    // apply methods can be called by class()
    println(mary.apply())
    println(mary()) // equivalent

    /*
    1. Overload the + operator
        mary + "the rockstar" => new person "Mary (the rockstar)"
     */

    class Human(val name: String, val favoriteMovie: String, val age: Int = 0) {
        def +(string: String) : String = s"${this.name} (${string})"
        def unary_+ : Human = new Human(this.name, this.favoriteMovie, this.age + 1)
        def learns(string: String) : String = s"${this.name} learns ${string}"
        def learnsScala() : String = this.learns("Scala")
        def apply(count : Int) : String = s"${this.name} watched ${this.favoriteMovie} ${count} times"
    }

    val brandon = new Human("Brandon", "300", 26)

    println(brandon + "ChromeDome")
    println((+brandon).age)
    println(brandon.learnsScala())
    println(brandon(5))

}
