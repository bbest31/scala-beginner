package lectures.Part1Basics

object CBNvsCBV extends App {

    def calledByValue(x: Long): Unit = {
        println("by value " + x)
        println("by value " + x)
    }

    /* By name means evaluate the value of x each time it's name is mentioned
        equivalent to:
        def callByName(x: => Long): Unit = { println("by name" + System.nanoTime()); println("by name" + System.nanoTime()) }
    */
    def calledByName(x: => Long): Unit = {
        println("by name " + x)
        println("by name " + x)
    }

    calledByValue(System.nanoTime())
    calledByName(System.nanoTime())

    def infinite(): Int = 1 + infinite()
    def printFirst(x: Int, y: => Int) = println(x)

    //printFirst(infinite(), 34) => crashes since infinite is evaluated so it can be passed in.
    printFirst(34, infinite()) // works fine since infinite is call by name so it doesn't eval until it is called.
}
