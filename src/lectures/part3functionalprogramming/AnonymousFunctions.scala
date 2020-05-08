package lectures.part3functionalprogramming

object AnonymousFunctions extends App {

    // Anonymous function (lambda)
    val doubler: Int => Int = (x) => x * 2 // == val doubler = (x: Int) => x * 2

    //Multiple parameters in a lambda

    val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

    // no params
    val doSomething: () => Int = () => 3

    println(doSomething) // when it comes to lambda's you must use the parenthesis in order to call the function rather than reference it.
    println(doSomething())

    // curly braces with lambdas

    val stringToInt = { (str: String) =>
        str.toInt
    }

    // MOAR syntatic sugar

    val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
    val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b

    /*
    1. In MyList replace all FunctionX calls with lambdas
    2. Rewrite the special adder as an anonymous function.

     */

    val superAdd = (x: Int) => (y: Int) => x + y
    println(superAdd(3)(4))
}
