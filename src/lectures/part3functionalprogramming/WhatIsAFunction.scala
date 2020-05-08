package lectures.part3functionalprogramming

object WhatIsAFunction extends App {

    //DREAM: Use functions as first class elements
    // problem: OOP


    val doubler = new MyFunction[Int, Int] {
        override def apply(elem: Int): Int = elem * 2
    }

    println(doubler(2))

    // Function types = Function1[A, B]
    // Supports up to Function22 which has 22 parameters
    val stringToIntConverter = new Function[String, Int] {
        override def apply(v1: String): Int = v1.toInt
    }

    println(stringToIntConverter("3") + 4)

    // Function2 with synatic sugar
    /*
    val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
        override def apply(v1: Int, v2: Int): Int = v1 + v2
    }
     */

    val adder = new Function2[Int, Int, Int] {
        override def apply(v1: Int, v2: Int): Int = v1 + v2
    }

    // Function types Function2[A, B, R] == (A,B) => R

    // ALL SCALA FUNCTIONS ARE OBJECTS

    val concatenator = new Function2[String, String, String] {
        override def apply(s1: String, s2: String): String = s1 + s2
    }

    val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
        override def apply(i: Int): Function1[Int, Int] = new Function1[Int, Int] {
            override def apply(v1: Int): Int = i + v1
        }
    }

    val adder3 = superAdder(3)
    println(adder3(4))
    println(superAdder(3)(4)) // curried function

}


trait MyFunction[A, B] {
    def apply(elem: A): B
}

trait MyTransformer[A, B] {
    def apply(elem: A): B
}

trait MyPredicate[-A] {
    def apply(elem: A): Boolean
}

// How to use predicate as a function
// def filter(predicate: A => Boolean) : Boolean = {...}
