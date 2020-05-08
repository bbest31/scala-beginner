package lectures.part2oop

object Inheritance extends App {

    // single class Inheritance
    class Animal {
        val creatureType = "wild"
        def eat = println("nomnom")
        private def sound = println("*Noise*") // this method will not be accessible by child classes
        protected final def walk = println("*Walk*") // this method will be accessible by child classes, but final makes it not overridable
    }

    class Cat extends Animal

    val cat = new Cat
    cat.eat

    //constructors
    class Person(name: String, age: Int) {
        def this(name: String) = this(name, 0) // this allows extension of Person(name)
    }

    class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

    // Overriding
    // You may also override class values in the constructor
    class Dog(override val creatureType: String) extends Animal {
        //override val creatureType: String = "domestic"
        override def eat = {
            super.eat
            println("crunch crunch")
        }
    }

    val dog = new Dog("K9")
    dog.eat
    println(dog.creatureType)

    // Type Substitution: polymorphism

    val unknownAnimal: Animal = new Dog("K9")
    unknownAnimal.eat

    //preventing overrides
    // 1 - use the keyword final on a val or method
    // 2 - use keyword final on the class itself
    // 3 - use the keyword sealed blocks it from be extended in other files.


}
