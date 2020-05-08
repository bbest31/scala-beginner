package exercises

 abstract class MyList[+A] {

     /*
     Singly linked list of integers
     head = first element of the list
     tail = remainder of the list
     isEmpty = boolean
     add(int) = new list with element added at the tail
     toString = override this
      */
     def head: A
     def tail: MyList[A]
     def isEmpty: Boolean
     def add[B >: A](element: B): MyList[B]
     override def toString: String = "[" + printElements + "]"
     def printElements: String
     def map[B](transformer: MyTransformer[A, B]): MyList[B]
     def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
     def filter(predicate: MyPredicate[A]): MyList[A]

     def ++[B >: A](list: MyList[B]): MyList[B]

     // hofs
     def forEach(f: A => Unit): Unit
     def sort(f: (A, A) => Int): MyList[A]
     def zipWith[B,C](list: MyList[B],f: (A, B) => C): MyList[C]
     def fold[B](start: B)(operator: (B, A) => B) : B

}

case object Empty extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: MyList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
    override def printElements: String = " "

    def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
    def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
    def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
    def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

    // hofs
    override def forEach(f: Nothing => Unit) = ()
    override def sort(f: (Nothing, Nothing) => Int) = Empty

    override def zipWith[B,C](list: MyList[B], f: (Nothing, B) => C) = {
        if(!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
        else Empty
    }

    override def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
    def head: A = h
    def tail: MyList[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](element: B): MyList[B] = new Cons(element, this)

    override def printElements: String =
        if(t.isEmpty) "" + h
        else h + " " + t.printElements

    def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
        new Cons(transformer.transform(h), t.map(transformer))
    }

    def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)


    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = transformer.transform(h) ++ t.flatMap(transformer)


    def filter(predicate: MyPredicate[A]): MyList[A] = {
        if (predicate.test(h)) new Cons(h, t.filter(predicate))
        else t.filter(predicate)
    }

    def forEach(f: A => Unit) = {
        f(h)
        t.forEach(f)
    }

    def sort(f:(A, A) => Int): MyList[A] = {

        def insert(x: A, sortedList: MyList[A]): MyList[A] = {
            if( sortedList.isEmpty) {
                new Cons(x, Empty)
            } else if(f(x,sortedList.head) <= 0) {
                new Cons(x, sortedList)
            } else {
                new Cons(sortedList.head, insert(x, sortedList.tail))
            }
        }
        val sortedTail = t.sort(f)

        insert(h,sortedTail)
    }

    override def zipWith[B,C](list: MyList[B], f: (A, B) => C): MyList[C] = {
        if(list.isEmpty) throw new RuntimeException("List do not have the same length")
        else new Cons(f(h, list.head), t.zipWith(list.tail, f))
    }

    def fold[B](start: B)(operator: (B, A) => B): B = {
        t.fold(operator(start, h))(operator)
    }
}

trait MyPredicate[-T] {
    def test(t: T): Boolean
}

trait MyTransformer[-A, B] {
    def transform(a: A): B
}

object ListTest extends App {
    val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
    val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
    val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

//    println(listOfIntegers.toString)
//    println(listOfStrings.toString)
//
//
//    println(listOfIntegers.map(elem => elem * 2).toString)
//
//    println(listOfIntegers.filter(elem => elem % 2 == 0).toString)
//
//    println((listOfIntegers ++ anotherListOfIntegers).toString)
//    println(listOfIntegers.flatMap(elem => new Cons(elem, Cons(elem + 1, Empty))).toString)

    listOfIntegers.forEach(x => println(x))
    println(listOfIntegers.sort((x,y) => y - x))
    println(anotherListOfIntegers.zipWith[String, String](listOfStrings, _ + "-" + _))
    println(listOfIntegers.fold(1)((x, y) => x * y))

    val combos = for {
        n <- listOfIntegers
        s <- listOfStrings
    } yield n + "-" + s
    println(combos)
}
