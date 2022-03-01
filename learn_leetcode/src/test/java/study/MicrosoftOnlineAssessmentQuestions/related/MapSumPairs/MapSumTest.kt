package study.MicrosoftOnlineAssessmentQuestions.related.MapSumPairs

import org.junit.Assert
import org.junit.Test

class MapSumTest {
    @Test
    fun test() {
        MapSum().apply {
            insert("apple", 3)
            val result1 = sum("ap")
            Assert.assertEquals(3, result1)
            insert("app", 2)
            val result2 = sum("ap")
            Assert.assertEquals(5, result2)
        }
    }
}