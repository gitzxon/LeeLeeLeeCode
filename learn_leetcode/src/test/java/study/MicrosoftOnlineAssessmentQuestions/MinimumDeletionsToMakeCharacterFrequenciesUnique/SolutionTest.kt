package study.MicrosoftOnlineAssessmentQuestions.MinimumDeletionsToMakeCharacterFrequenciesUnique

import org.junit.Assert
import org.junit.Test

class SolutionTest {
    @Test
    fun minDeletions() {

        Assert.assertEquals(
            0,
            Solution().minDeletions("")
        )

        Assert.assertEquals(
            0,
            Solution().minDeletions("a")
        )

        Assert.assertEquals(
            1,
            Solution().minDeletions("ab")
        )

        Assert.assertEquals(
            0,
            Solution().minDeletions("aab")
        )

        Assert.assertEquals(
            1,
            Solution().minDeletions("aabb")
        )

        Assert.assertEquals(
            2,
            Solution().minDeletions("aabbc")
        )

        Assert.assertEquals(
            3,
            Solution().minDeletions("aabbcc")
        )


        Assert.assertEquals(
            2,
            Solution().minDeletions("aaabbbcc")
        )

        Assert.assertEquals(
            2,
            Solution().minDeletions("ceabaacb")
        )
    }

    @Test
    fun minDeletions_1() {
        Assert.assertEquals(
            2,
            Solution().minDeletions("bbbbcea")
        )
    }
}