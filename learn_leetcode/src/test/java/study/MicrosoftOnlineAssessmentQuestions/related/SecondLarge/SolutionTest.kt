package study.MicrosoftOnlineAssessmentQuestions.related.SecondLarge

import org.junit.Assert
import org.junit.Test

class SolutionTest {
    @Test
    fun secondHighest() {
        Assert.assertEquals(
            2,
            Solution().secondHighest("dfa12321afd")
        )

        Assert.assertEquals(
            -1,
            Solution().secondHighest("abc1111")
        )

        Assert.assertEquals(
            4,
            Solution().secondHighest("sjhtz8344")
        )

    }
}