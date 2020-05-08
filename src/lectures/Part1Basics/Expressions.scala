package lectures.Part1Basics

object Expressions extends App {
    val x = 1 + 2 // EXPRESSION
    println(x)

    println(2 + 3 * 4)
    // + - / & | ^ << >> >>>

    println(1 == x)
    // == != > >= < <=

    println(!(1 == x))
    // ! && ||

    var variable = 2

    variable += 3 // (side-effect) also works with -= *= /=
    println(variable)

    // Instructions (DO) vs Expressions (VALUE)

    // IF expression
    val aCondition = true
    val aConditionedValue = if(aCondition) 5 else 3 // IF acts as an expression so returns a value of 5
    println(aConditionedValue)

    var i = 0
    while (i < 10) {
        println(i)
        i += 1
    }

    // NEVER WRITE THIS AGAIN

    // EVERYTHING in Scala is an Expression

    val a = (variable = 3) // Unit == void, the variable is reassigned but returns nothing so a = Unit(void)
    println(a)

    // side effects: println(), whiles, reassigning

    // Code Blocks
    // the value of the block is the value of the last expression
    // the vals or vars inside the code block are scoped to the block

    val codeBlock = {
        val y = 2
        val z = y + 1

        if (z > 2) "hello" else "goodbye"
    }

    // 1. difference between the "hello world" vs println("hello world")?
    // A: string literal and an Unit expression
    // 2.

    val someValue = {
        2 < 3
    }
    // = true

    val someOtherValue = {
        if (someValue) 239 else 985
        42
    }

    // = 42







}
