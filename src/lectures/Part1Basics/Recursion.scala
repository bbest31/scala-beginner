package lectures.Part1Basics

import java.util.concurrent.atomic.DoubleAccumulator

import scala.annotation.tailrec

object Recursion extends App {

    // Stack recursion - recurses down the calls until it hits the base case then returns values all the way back up.
    // This way can take the JVM stack and have a stack overflow error due to too many calls on the stack.
    def factorial(n: Int): Int = {
        if (n <= 1) 1
        else {
            println("Computing factorial of " + n + ", but first I need " + (n - 1))
            val result = n * factorial(n - 1)
            println("Computed factorial of " + n)
            result
        }
    }

    println(factorial(10))

    // Use a sub-function to calculate so the JVM doesn't use more stack frames but rather replaces the current one
    // since factorialTail is not being called again. It is only factHelper that gets the recursive call as the LAST expression
    // TAIL RECURSION = use recursive call as the LAST expression alone in the line so not => x + call(n-1) JUST call(n - 1)
    def factorialTail(n: BigInt): BigInt = {
        def factHelper(x: BigInt, accumulator: BigInt): BigInt = {
            if (x <= 1) accumulator
            else factHelper(x -1, x * accumulator)
        }

        factHelper(n, 1)
    }

    println(factorialTail(5000))

    /*
    factorialTal(10) = factHelper(10, 1)
    = factHelper(9, 10 *1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * 4 ... * 10 * 1)
    = factHelper(1, 2 * 3 ... * 10 * 1)
    = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10
     */


    /*
    1. Concat a string and times using tail recursion
    2. isPrime function tail recursion
    3. Fibonacci function tail recursion
     */

    // 1.
    def concatString(s: String, t: BigInt): String = {
        @tailrec
        def concatTail(s: String, t: BigInt, accumulator: String): String = {
            if (t <= 1) accumulator
            else concatTail(s, t-1, accumulator + s)
        }

        concatTail(s,t,s)
    }

    println(concatString("hello",3))

    def fibonacci(n: Int): Int = {
        @tailrec
        def fibTail(i: Int, f1: Int, f2: Int): Int = {
            if (i >= n) f1
            else fibTail(i + 1, f2 + f1, f1)
        }

        if (n <= 2) 1
        else fibTail(2, 1, 1)
    }

    def isPrime(n: Int): Boolean = {
        @tailrec
        def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
            if (!isStillPrime) false
            else if (t <= 1) true
            else isPrimeTailrec(t-1, n % t != 0 && isStillPrime)
        }

        isPrimeTailrec(n / 2, true)
    }

}
