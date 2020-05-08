package lectures.part3functionalprogramming

import scala.util.Random

object Sequences extends App {

    // Sequences
    val aSequence = Seq(1,3,2,4)
    println(aSequence)
    println(aSequence.reverse)
    println(aSequence(2))
    println(aSequence ++ Seq(5,6,7))
    println(aSequence.sorted)

    // Ranges
    val aRange: Seq[Int] = 1 to 10 // inclusive
    // val aRange: Seq[Int] = 1 until 10 // exclusive
    aRange.foreach(println)

    (1 to 10).foreach(x => println(x))

    // Lists
    val aList = List(1,2,3)
    val prepended = 42 :: aList // can also use +:
    println(prepended)
    val appended = aList :+ 31
    println(appended)

    val fiveApples = List.fill(5)("apple") // curried function that makes a List of 5 elements all of which are the string 'apple'
    println(fiveApples)
    println(aList.mkString("-|-")) // prints a List with the specified separator

    // Arrays
    val numbers = Array(1, 2, 3, 4)
    val threeElements = Array.ofDim[Int](3)
    println(threeElements) // prints object Id
    threeElements.foreach(println) // prints default values of 0 for primitive types (int, double, etc.) and null for reference types (String, Objects).

    //mutation
    numbers(2) = 0 //syntax sugar for numbers.update(2, 0)
    println(numbers.mkString(" "))

    // arrays and seq
    val numbersSeq: Seq[Int] = numbers // implicit conversion of Array => Seq
    println(numbersSeq)

    // Vectors
    // the default implementation for immutable sequences
    // effectively constant indexed read and write: O(log_32(n))
    // fast element addition: prepend/append
    // implemented as a fixed-branch trie (so each level of the tree has at most 32 branches)
    // good performance for large sizes
    val vector: Vector[Int] = Vector(1,2,3)
    println(vector)

    // vectors vs lists
    val maxRuns = 1000
    val maxCapacity= 1000000
    def getWriteTime(collection: Seq[Int]): Double = {
        val r = new Random
        val times = for {
            it <- 1 to maxRuns
        } yield {
            val currentTime = System.nanoTime()
            // operation
            collection.updated(r.nextInt(maxCapacity), r.nextInt())
            System.nanoTime() - currentTime
        }

        times.sum * 1.0 / maxRuns
    }

    val numbersList = (1 to maxCapacity).toList
    val numbersVector = (1 to maxCapacity).toVector

    // adv: keeps reference to tails
    // disadv: updating the element in the middle takes a long time
    println(getWriteTime(numbersList))
    // adv: depth of the tree is small
    // disadv: needs to replace an entire 32-element chunk
    println(getWriteTime(numbersVector))

}
