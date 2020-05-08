package lectures.part2oop

object OOBasics extends App {

    val person = new Person("Brandon", 26)
    println(person.x)
    person.greet("Emma")
    person.greet()

    val writer = new Writer("Ben", "Counter",1980)

    println(writer.getFullname())


}

class Person(name: String, val age: Int = 0) {

    val x = 2 // Fields
    println(1 + 3) //Expression

    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

    // overloading
    def greet(): Unit = println(s"Hi, I am $name")

    // multiple constructors
    def this(name: String) = this(name, 0) // not super useful since it uses just another constructor. better off using default param values in original constructor
    def this() = this("John Doe")
}

/*
Novel and a Writer class
Writer: first name, surname, year of birth
- method fullname
Novel: name, year of release, author -> instance of Writer
-authorAge: age of author at year of release
-isWrittenBy(author)
- copy (new year of release) = new instance of Novel.
 */

class Writer(firstName: String, surname: String, val birthYear: Int) {
    def getFullname(): String = firstName + " " + surname
}



class Novel(name: String, year: Int, author: Writer) {

    def authorAge(): Int = year - author.birthYear

    def isWrittenBy(author: Writer) = author == this.author

    def copy(newYear: Int): Novel = new Novel(this.name, newYear, author)
}





/*
Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */

class Counter(val n: Int) {

    def increment(): Counter = new Counter(n + 1)

    def increment(m: Int): Counter = new Counter(n + m)

    def decrement(): Counter = new Counter(n - 1)

    def decrement(m: Int): Counter = new Counter(n - m)
}

// class parameters are NOT FIELDS unless you add val before