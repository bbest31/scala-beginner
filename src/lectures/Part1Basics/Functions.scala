package lectures.Part1Basics

/**
  *
  */
object Functions extends App {

    def aFunction(a: String, b: Int) = {
        a + " " + b
    }

    println(aFunction("hello", 3))

    def aParameterLessFunction(): Int = 42
    println(aParameterLessFunction())
    println(aParameterLessFunction)

    def aRepeatedFunction(a: String, b: Int): String = {
        if (b == 1) a
        else a + aRepeatedFunction(a, b-1)
    }

    println(aRepeatedFunction("hello", 3))

    // When you needs loops, USE RECURSION

    def aFunctionWithSideEffects(a: String): Unit = {
        println(a)
    }

    def aBigFunction(n: Int): Int = {
        def aSmallerFunction(a: Int, b: Int): Int = a + b

        aSmallerFunction(n, n-1)
    }

    /*
    1. A greeting function (name, age) => "Hi, my name is <name> and I am <age> years old"
    2. Factorial Function 1 * 2 * 3 * ... * n
    3. Fibonacci Function
        f(0) = 1
        f(1) = 1
        f(2) = 1
        f(n) f(n - 1) + f(n - 2)
    4. Tests is a number is prime.
     */


    // 1.

    def greeting(name: String, age: Int): String = {
        "Hi my name is " + name + " and I am " + age + " years old."
    }

    println(greeting("Brandon", 26))

    def factorialFunction(n: Int): Int = {
        if (n == 1) 1
        else n * factorialFunction(n-1)
    }

    println(factorialFunction(5))

    def fibonnacci(n: Int): Int = {
        if (n == 1 || n == 2) 1
        else fibonnacci(n - 1) + fibonnacci(n - 2)
    }

    println(fibonnacci(7))


    def isPrime(n: Int): Boolean = {
        def isPrimeUntil(t: Int): Boolean  = {
            if (t <= 1) true
            else n % t != 0 && isPrimeUntil(t - 1)
        }

        isPrimeUntil(n / 2)
    }

}
