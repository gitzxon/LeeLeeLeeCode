package coroutine.share

import kotlinx.coroutines.*
import kotlin.coroutines.resume


fun main() {
    SuspendCancelable().main()
}

class SuspendCancelable {
    fun main() = runBlocking {
        suspendCancellableCoroutine<Int> {
            launch(Dispatchers.Default) {
                delay(3000)
                println("after delay 3000")
                it.resume(666)
            }
        }
        println("end of main()")

    }

    fun main2() = runBlocking {
        launch(Dispatchers.Default) {
            delay(3000)
            println("after delay 3000")
        }
        println("end of main()")
    }
}
