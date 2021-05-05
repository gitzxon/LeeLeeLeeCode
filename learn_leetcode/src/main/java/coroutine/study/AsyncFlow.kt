package coroutine.study

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main(args: Array<String>) = runBlocking {
    flatMapLatest()
}

suspend fun flatMapLatest() {
    val startTime = System.currentTimeMillis() // remember the start time
//    (1..3).asFlow().onEach {
//        println(" start foreach $it at ${System.currentTimeMillis() - startTime} ms ")
//    } // a number every 100 ms

        flow {

            println("start 1")
            emit(1)
            println("end 1")
            fakeSuspend()
            println("before delay")
            delay(1)
            println("after delay")
            println("start 2")
            emit(2)
            println("start 3")
            emit(3)
            println("end 3")
        }
        .flatMapLatest {
            println(" $it start flat map")
            requestFlow(it)
        }.collect { value -> // collect and print
            val a = value
            println("in collect ==== ")
            println(" in collect $value at ${System.currentTimeMillis() - startTime} ms from start")
        }


    // 通过 flatMapLatest 拿到一个结果之后，会先回到开始的 onEach 里面。执行到 delay 。那么如果没有 delay 会怎样呢？
}

suspend fun fakeSuspend() {
    println("<top>.fakeSuspend")
    println("test yield")
    yield()
    println("0 delay")
    delay(1)
    println("1 delay")
}

fun requestFlow(i: Int): Flow<String> = flow {
    println("emmit ______$i: First")
    emit("______$i: First")
    delay(500) // wait 500 ms
    println("emmit ______$i: Second")
    emit("______$i: Second")
}

