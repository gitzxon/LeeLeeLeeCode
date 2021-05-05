package coroutine.share

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import java.util.concurrent.atomic.AtomicReference





fun main() {
    KTXSucks().main()
}
class KTXSucks {

    var mInternalScopeRef = AtomicReference<Any>()

    fun main() = runBlocking {

        val channel = Channel<Int>()

        GlobalScope.launch {
            var i = 0
            while (true) {
                delay(100)
                channel.send(i++)
            }

        }

        while (true) {
            val value = channel.receive()
            println("value = ${value}")
        }


//        repeat(100) {
//            launch(Dispatchers.Default) {
//                delay(100)
//                perform()
//            }
//        }
    }

    fun perform() = runBlocking {
        while (true) {
            val existing = mInternalScopeRef.get() as Job?
            if (existing != null) { break }
            val job = Job()
            println("job created")
            if (mInternalScopeRef.compareAndSet(null, job)) {
                break
            }
        }
    }
}