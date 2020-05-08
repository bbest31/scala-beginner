package lectures.part2oop

object AnonymousClasses extends App {

    abstract class Animal {
        def eat: Unit
    }

    // Anonymous class
    // allows you to instantiate types and override fields or methods on the spot.
    val funnyAnimal: Animal = new Animal {
        override def eat: Unit = println("hahahahah")
    }

    /*
     class AnonymousClasses$$anon$1 extends Animal {
        override def eat: Unit = println("hahahahaha")
     }
     val funnyAnimal: Animal = new AnonymousClasses$$anon$1
     */

    println(funnyAnimal.getClass)

    class Person(name: String) {
        def sayHi: Unit = println(s"Hi my name is $name")
    }

    val jim = new Person("Jim") {
        override def sayHi: Unit = println(s"Hi my name is Jim")
    }

    /*
    1. Generic trait myPredicate[-T] with a little method test(T) => Boolean
    2. Generic trait MyTransformer[-A, B] method tranform(A) => B
    3. MyList:
        - map(transformer) => MyList of a different type
        - filter(predicate) => MyList
        - flatMap(transformer from A to MyList[B]) -> MyList[B]

        class EvenPredicate extends My Predicate[Int]
        class StringToIntTransformer extends MyTransformer[String, Int]
     */



}
