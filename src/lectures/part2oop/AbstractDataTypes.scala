package lectures.part2oop

object AbstractDataTypes extends App {

    // abstract
    abstract class Animal {
        val creatureType: String
        def eat: Unit
    }

    class Dog extends Animal {
        override val creatureType: String = "K9"
        override def eat: Unit = println("crunch crunch")
    }

    // Traits - act like Interfaces
    trait Carnivore {
        def eat(animal: Animal): Unit
        val preferredMeal: String = "Meat"
    }

    class Crocodile extends Animal with Carnivore {
        override val creatureType: String = "reptile"
        def eat: Unit = println("snap snap")
        override def eat(animal: Animal): Unit = println(s"I'm a Crocodile and I'm eating ${animal.creatureType}")
    }

    // Traits vs Abstract Classes
    /*
    1. Traits can have implemented methods/values
    2. Multiple traits can be inherited.
    3. Traits do not have constructor parameters
    4. Traits = behaviour, Abstract Class = "thing"
     */

}
