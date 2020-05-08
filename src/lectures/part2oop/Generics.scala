package lectures.part2oop

object Generics extends App {

    class MyList[+A] {
        // use the type A (generic)
        def add[B >: A](element: B): MyList[B] = ???
        /*
         A = Cat
         B = Animal
         */
    }

    class MyMap[Key, Value]

    val listOfIntegers = new MyList[Int]
    val listOfStrings = new MyList[String]


    // generic methods
    object MyList {
        def empty[A]: MyList[A] = ???
    }

    val emptyListOfInts = MyList.empty[Int]

    // variance problem
    class Animal
    class Cat extends Animal
    class Dog extends Animal

    // 1. Yes, List[Cat] extends List[Animal] = COVARIANCE
    class CovariantList[+A]
    val animalList: CovariantList[Animal] = new CovariantList[Cat]
    // animalList.add(new Dog) ??? => We return a list of Animals

    // 2. No = INVARIANCE
    class InvariantList[A]
    val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

    // 3. Hell No, = CONTRAVARIANCE
    class Trainer[-A]
    val trainer: Trainer[Cat] = new Trainer[Animal]

    // BOUNDED TYPES
    // Allow you to use your generic types only for subclasses of certain types

    // Cage only accepts types that are subtypes of Animal
    // If we did [A >: Cat] then it would only accept supertypes of Cat
    class Cage[A <: Animal](animal: A)
    val cage = new Cage(new Dog)




}
