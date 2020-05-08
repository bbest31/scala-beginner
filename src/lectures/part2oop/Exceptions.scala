package lectures.part2oop

object Exceptions extends App {

    val x: String = null


    // throwable classes extend the Throwable class
    // Exception and Error are the major Throwable Subtypes

    def getInt(withExceptions: Boolean): Int = {
        if (withExceptions) throw new RuntimeException("No int for you")
        else 31
    }

    try {
        getInt(true)
    } catch {
        case e: RuntimeException => println("Catch a RunTimeException")
    } finally {
        //code that will get executed no matter what
        println("finally")
    }

    class MyException extends Exception
    val exception = new MyException


    // OutOfMemoryError
    val array = Array.ofDim(Int.MaxValue)

    //StackOverflow
    def infinite: Int = 1 + infinite
    val noLimit = infinite

    class OverflowException extends RuntimeException
    class UnderflowException extends RuntimeException
    class MathCalculationException extends RuntimeException("Division by 0")
    object PocketCalculator {
        def add(x: Int, y: Int) = {
            val result = x + y
            if(x > 0 && y > 0 && result < 0) throw new OverflowException
            else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
            else result
        }

        def subtract(x: Int, y: Int) = {
            val result = x - y
            if(x > 0 && y < 0 && result < 0) throw new OverflowException
            else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
            else result
        }

        def multiple(x: Int, y: Int) = {
            val result = x * y
            if(x > 0 && y > 0 && result < 0) throw new OverflowException
            else if (x < 0 && y < 0 && result < 0) throw new OverflowException
            else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
            else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
            else result
        }

        def divide(x: Int, y: Int) = {
            if(y == 0) throw new MathCalculationException
            else x / y
        }
    }

}
