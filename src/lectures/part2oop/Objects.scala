package lectures.part2oop

object Objects extends App {
    // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")

    object Person { // defines the type and it's only instance
        // static/class level functionality
        val N_EYES = 2
        def canFly: Boolean = false

        // Factory method can also override the apply method as well.
        def from(mother: Person, father: Person): Person = new Person("Bobbie")
    }

    class Person (val name: String) {
        // instance-level functionality

    }

    // Class and object of Person are companions when created in the same scope.

    println(Person.N_EYES)
    println(Person.canFly) // can be accessed without an instance of the object.

    // Scala Object = Singleton instance
    val brandon = Person
    val emma = Person
    println(brandon == emma) // true since they both point to the same instance

    val person1 = new Person("John")
    val person2 = new Person("Jane")
    println(person1 == person2) // false since they are using the class Person

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit

}
