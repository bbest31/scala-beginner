package lectures.part3functionalprogramming

object MapFlatMapFilterFor extends App {

    val list = List(1,2,3)
    println(list)
    println(list.head) // 1
    println(list.tail) // List(2, 3)

    // map - do some operation on each element
    println(list.map( _ + 1))
    println(list.map(_ + " is a number"))

    // filter - if the predicate is true then add to the new list to be returned
    println(list.filter(_ % 2 == 0))
    println(list.filter(_ % 2 != 0))

    // flatMap - does operation for all items and returns them wrapped in the collection type such that everything is on the same level (non-nested)
    val toPair = (x: Int) => List(x, x + 1)
    println(list.flatMap(toPair))

    // print all combinations between two lists
    val numbers = List(1,2,3,4)
    val characters = List("a", "b", "c", "d")

    // "iterating"
    val combinations = numbers.flatMap(n => characters.map(c => "" + c + n))
    println(combinations)

    //foreach - returns a Unit
    list.foreach(println)

    //for-comprehensions
    val forCombinations = for {
        n <- numbers // can also write: numbers if n % 2 == 0 to further filter the elements
        c <- characters
    } yield "" + c + n

    println(forCombinations)

    for {
        n <- numbers
    } println(n)

    // syntax overload
    list.map {x =>
        x * 2
    }

    /*
    1. MyList supports for-comprehensions?
    2. Implement a small collection of at most one element - Maybe[+T]
        -map, flatMap, filter
     */


}
