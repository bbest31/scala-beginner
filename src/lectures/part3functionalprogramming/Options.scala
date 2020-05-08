package lectures.part3functionalprogramming

import scala.util.Random

object Options extends App {

    val myFirstOption: Option[Int] = Some(4)
    val noOption: Option[Int] = None

    println(myFirstOption)
    println(noOption)

    // were created to deal with unsafe APIs

    def unsafeMethod(): String = null
    val result = Option(unsafeMethod()) // Some or None
    println(result) // None - Option type does the null check for us

    // chained methods
    def backupMethod(): String = "A valid result"
    val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))


    // Design unsafe APIs
    // make methods return Options instead of nulls
    def betterUnsafeMethod(): Option[String] = None
    def betterBackupMethod(): Option[String] = Some("A valid result")

    val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

    // Functions on Options
    println(myFirstOption.isEmpty)
    println(myFirstOption.get) // UNSAFE - DO NOT USE THIS

    // map, flatMap, filter
    println(myFirstOption.map(_ * 2)) // Some(8)
    println(myFirstOption.filter(x => x > 10)) // turn Some(4) into None
    println(myFirstOption.flatMap(x => Option(x * 10)))

    // for-comprehensions
    /*
    Exercise
     */
    // values for host and port may or may not be there
    val config: Map[String, String] = Map(
        "host" -> "123.45.67.8",
        "port" -> "80"
    )

    class Connection {
        def connect = "Connected" // connect to some server
    }

    object Connection {
        val random = new Random(System.nanoTime())
        def apply(host: String, port: String): Option[Connection] = {
            if (random.nextBoolean()) Some(new Connection)
            else None
        }
    }

    // try to establish a connection - if so print the connect method
    val host: Option[String] = config.get("host")
    val port: Option[String] = config.get("port")

    /*
        if (h != null)
            if (p != null)
                return Connection.apply(h, p)
     */
    val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
    /*
    if( c != null)
        return c.connect
    return null
     */
    val connectionStatus = connection.map(c => c.connect)
    /*
    if (connectionStatus == null) print None else print Some(connectionStatus.get)
     */
    println(connectionStatus)
    connectionStatus.foreach(println)

    // for-comprehension
    val forConnectionStatus = for {
        host <- config.get("host")
        port <- config.get("port")
        connection <- Connection(host, port)
    } yield connection.connect
    forConnectionStatus.foreach(println)
}
