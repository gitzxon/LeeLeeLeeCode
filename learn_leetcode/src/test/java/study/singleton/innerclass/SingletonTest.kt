package study.singleton.innerclass

import org.junit.Test
import kotlin.concurrent.thread

class SingletonTest {
    @Test
    fun testGetInstance() {
        for (i in 0 until 20) {
            thread { Singleton.getInstance() }
        }
        Thread.sleep(3000)
    }
}