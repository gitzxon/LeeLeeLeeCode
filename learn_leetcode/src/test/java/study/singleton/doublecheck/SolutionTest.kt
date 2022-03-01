package study.singleton.doublecheck

import org.junit.Test
import study.singleton.innerclass.Singleton
import kotlin.concurrent.thread

class SolutionTest {
    @Test
    fun testGetInstance() {

        for (i in 0 until 20) {
            thread { Solution.getInstance() }
        }
        Thread.sleep(3000)
    }
}