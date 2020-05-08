package lectures.part2oop

object CaseClasses extends App {

    // Classes to shorten the amount of code needed to override the typical toString, hashCode, etc. methods in a class

    case class Person(name: String, age: Int)

    //1. class parameters are fields so if they had val infront of the param
    val jim = new Person("Jim", 34)
    println(jim.name)

    //2. sensible toString
    println(jim.toString)

    //3. equals and hashCode are implemented out of the box
    val jim2 = new Person("Jim", 34)
    println(jim == jim2)

    // 4. Case Classes have handy copy method
    val jim3 = jim.copy(age = 45)
    println(jim3)

    // 5. Case Classes have companion Objects

    val thePerson = Person

    val mary = Person("Mary", 32)

    // 6. Case Classes are serializable

    // 7. Have extractor patterns which means they can be used in Pattern Matching

    case object UnitedKingdom {
        def name: String = "The UK of GB and NI"
    }

    /*

     */

}
