import java.io.InputStream
import java.net.ServerSocket

class Server(port: Int) {

    private val serverSocket = ServerSocket(port);

    fun acceptMultiThread() {
        while (true) {
            val socket = serverSocket.accept()
            val inputStream = socket.getInputStream()
            Thread { read(inputStream) }.start()
        }
    }

    private fun read(inputStream: InputStream) {
        val br = inputStream.bufferedReader()
        while (true) {
            try {
                val text = br.readLines()
                println(text)
            } catch (e: Exception) {
                break
            }
        }
    }
}

fun main() {
    Server(80)
        .acceptMultiThread()
}