package exercises

object OOExcercise extends App {

    trait MyPredicate[-T] {
        def test(t: T): Boolean
    }

    trait MyTransformer[-A, B] {
        def transform(a: A): B
    }



}
