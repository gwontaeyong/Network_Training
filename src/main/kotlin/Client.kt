import java.net.Socket
import kotlin.concurrent.thread

class Client(private val clientName: String) {

    fun connect(host: String, port: Int) {
        val socket = Socket(host, port)
        val output = socket.getOutputStream()

        output.write((clientName + "\n").toByteArray())
        (0..2).forEach {
            output.write(
                "$clientName  This is client $it\n".toByteArray()
            )
        }

    }
}
fun main() {
    thread {
        Client("client 1").connect("localhost", 80)
    }
    thread {
        Client("client 2").connect("localhost", 80)
    }
}