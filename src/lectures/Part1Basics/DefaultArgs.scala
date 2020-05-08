package lectures.Part1Basics

import scala.annotation.tailrec

object DefaultArgs extends App {

    @tailrec
    def trFactorial(n: Int, acc: Int = 1): Int = {
        if (n <= 1) acc
        else trFactorial(n-1, n*acc)
    }

    // we gave acc from having a default value of 1 if not passed in
    val fact10 = trFactorial(10)


    def savePic(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture...")

    // How do I pass in say only the second or the third param?
    // Naming arguments
    savePic(width = 800)
    // You may also change the order if passing in named parameters
    savePic(height = 600, width = 600, format = "png")

}
