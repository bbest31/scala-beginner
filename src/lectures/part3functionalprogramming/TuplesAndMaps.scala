package lectures.part3functionalprogramming

object TuplesAndMaps extends App {

    // tuples = finite ordered "lists"
    val aTuple = (2, "Hello Scala") // Tuple2[Int, String]
    println(aTuple._1)
    println(aTuple._2)
    println(aTuple.copy(_2 = "Goodbye Java"))
    println(aTuple.swap) // ("Hello Scala", 2)


    // Maps
    val aMap: Map[String, Int] = Map()

    val phoneBook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1) // both notations work. the default value is returned if queried with a key that is not in the map.
    println(phoneBook)

    //basic map ops
    println(phoneBook.contains("Jim"))
    println(phoneBook("Jim"))

    // add a pairing
    val newEntry = "Brandon" -> 977
    val newPhonebook = phoneBook + newEntry
    println(newPhonebook)

    // functionals on maps
    // map, flatMap, filter

    println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

    //filterKeys
    println(phoneBook.filterKeys(x => x.startsWith("J")))
    // mapValues
    println(phoneBook.mapValues(number => number * 10))

    //conversion to other collections

    println(phoneBook.toList)
    println(List(("Daniel", 555)).toMap)
    val names = List("Bob", "James", "Angela", "Brandon", "Emma", "Khalil")
    println(names.groupBy(name => name.charAt(0)))

/*
1. What would happen if I had had two original entries  "Jim" -> 555 and "JIM" -> 900 when running the lowercase line?
2. Overly simplified social network based on maps
    Person = String
    - add a Person to the network
    - remove a person
    - friend (mutual)
    - unfriend
    stats
    - number of friends of a person
    - Person with most friends
    - how many people have NO friends
    - if there is a social connection between two people (direct or not)
 */
    // 1. The second entry of pair "jim" -> will overwrite the first entry
    val testMap = Map("Jim" -> 555, "JIM" -> 900).withDefaultValue(-1)
    println(testMap.map(pair => pair._1.toLowerCase -> pair._2))

    // 2.
    case class Network() {

        var network: Map[String, List[String]] = Map()

        def addToNetwork(person: String): Unit = {
            val emptyList = List()
            val newPerson = person -> emptyList
            network = network + newPerson
        }

        def removeFromNetwork(person: String): Unit = {
            // remove from each friends list
            network.map(entry => entry._1 -> removeFriend(entry._1, person))
            // remove person's entry
            network = network.filterKeys(key => !key.contentEquals(person))
        }

        def addFriend(person1: String, person2: String): Unit = {
            network = network + (person1 -> (network(person1) :+ person2))
            network = network + (person2 -> (network(person2) :+ person1))
        }

        def removeFriend(person1: String, person2: String): Unit = {
            network = network + (person1 -> network(person1).filter(friend => !friend.contentEquals(person2)))
            network = network + (person2 -> network(person2).filter(friend => !friend.contentEquals(person1)))
        }

        def getNumberOfFriends(person: String): Int = {
            if(network.contains(person)) network(person).size
            else 0
        }

        def mostPopular(): String = {
            network.maxBy(pair => pair._2.size)._1
        }

        def numberOfFriendless(): Int = {
            network.count(pair => pair._2.isEmpty)
        }

        def isConnected(a: String, b: String): Boolean = {
            if(network(a).contains(b) && network(b).contains(a)) true
            else false
        }


    }

    val network = new Network()
    network.addToNetwork("Brandon")
    network.addToNetwork("Emma")
    network.addToNetwork("Khalil")
    network.addToNetwork("Chris")
    network.addToNetwork("Jim")
    network.addToNetwork("Bob")
    network.addToNetwork("Joe")
    println(network.network)
    network.addFriend("Brandon", "Emma")
    network.addFriend("Brandon", "Chris")
    network.addFriend("Khalil", "Emma")
    network.addFriend("Chris", "Emma")
    println(network.network)
    network.removeFriend("Brandon","Chris")
    println(network.network)
    network.removeFromNetwork("Khalil")
    println(network.network)
    println(network.getNumberOfFriends("Brandon"))
    println(network.mostPopular())
    println(network.numberOfFriendless())
    println(network.isConnected("Brandon", "Emma"))
    println(network.isConnected("Brandon", "Jim"))





}
