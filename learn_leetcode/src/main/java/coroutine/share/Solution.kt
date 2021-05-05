package coroutine.share

import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

fun main() {

    Solution().test()

}

class Solution {

    fun test() = runBlocking {

        val dispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher)
        scope.launch(context = CoroutineName("123")) {

            val job = coroutineContext[Job]
            println("My job is: ${job}")
            val coroutineContext = this.coroutineContext
            println("coroutineContext = ${coroutineContext}")

            delay(3000)

        }

        scope.launch {
            println("second test")
            println("Thread.currentThread() = ${Thread.currentThread()}")
        }

//        withContext(NonCancellable + dispatcher) {
//            // this code will not be cancelled
//            while (true) {
//                if (this.isActive) {
//                    delay(100)
//                    println("this = ${this}")
//                }
//            }
//        }

        delay(5000)

        println("coroutine finished")
    }
}

public interface MyJob : CoroutineContext.Element {
    /**
     * Key for [Job] instance in the coroutine context.
     */
    public companion object Key1 : CoroutineContext.Key<kotlinx.coroutines.Job> {
        init {
            /*
             * Here we make sure that CoroutineExceptionHandler is always initialized in advance, so
             * that if a coroutine fails due to StackOverflowError we don't fail to report this error
             * trying to initialize CoroutineExceptionHandler
             */
            CoroutineExceptionHandler
        }
    }
}