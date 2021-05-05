package coroutine.share

import kotlinx.coroutines.*
import java.io.IOException
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume


val uncaughtExceptionHandler = CoroutineExceptionHandler { coroutineContext: CoroutineContext, throwable: Throwable ->
    println("throwable caught $throwable")
}

fun main(): Unit = runBlocking(uncaughtExceptionHandler) {
    suspendCancellableCoroutine<Int> { cont ->

        GlobalScope.launch() {

            try {
                GlobalScope.async {
                    println("will throw IOExp")
                    throw IOException("sample IOExp")
                }

//                GlobalScope.launch() {
//                    println("will throw IOExp")
//                    throw IOException("sample IOExp")
//                }.join()
            } catch (t: Throwable) {
                println("in catch")
            } finally {
                println("in finally")
            }

            println("this.isActive = ${this.isActive}")
            delay(3000)
            println("this.isActive = ${this.isActive}")


            println("====== end of file")
            cont.resume(123)
        }
    }

    println("end of main")
}


fun main1() = runBlocking(uncaughtExceptionHandler) {


    val job = GlobalScope.launch { // root coroutine with launch
        println("Throwing exception from launch")
        throw IndexOutOfBoundsException() // Will be printed to the console by Thread.defaultUncaughtExceptionHandler
    }
    job.join()

    println("Joined failed job")
    val deferred = GlobalScope.async { // root coroutine with async
        println("Throwing exception from async")
        throw ArithmeticException() // Nothing is printed, relying on user to call await
    }
    try {
        deferred.await()
        println("Unreached")
    } catch (e: ArithmeticException) {
        println("Caught ArithmeticException")
    }
}