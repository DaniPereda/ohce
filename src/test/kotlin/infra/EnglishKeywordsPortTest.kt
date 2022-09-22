package infra

import infra.keywords.EnglishKeywordsPort
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class EnglishKeywordsPortTest {
    @Test
    fun `isStop true`(){
        //GIVEN
        val sut = EnglishKeywordsPort()

        //WHEN
        val result = sut.isStopKeyword("Stop!")

        //THEN
        assertEquals(true, result)
    }

    @Test
    fun `isStop false`(){
        //GIVEN
        val sut = EnglishKeywordsPort()

        //WHEN
        val result = sut.isStopKeyword("stop!")

        //THEN
        assertEquals(false, result)
    }
}