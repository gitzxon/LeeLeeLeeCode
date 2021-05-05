package coroutine.share

import kotlinx.coroutines.*
import java.util.concurrent.Executors

fun main() {
    SwitchThread().main()
}


class SwitchThread {
    fun main() {

        GlobalScope.launch(Dispatchers.Main) {
            // do on main thread
            withContext(Dispatchers.IO) {
                // network
            }
        }

        GlobalScope.launch(Dispatchers.IO) {  }
        GlobalScope.launch(Dispatchers.Default) {  }
        GlobalScope.launch(Dispatchers.Unconfined) {  }

        val myDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
    }
}