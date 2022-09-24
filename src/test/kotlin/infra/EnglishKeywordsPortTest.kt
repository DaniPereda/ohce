package infra

import domain.Keywords
import infra.keywords.EnglishKeywordsRepository
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class EnglishKeywordsPortTest {
    @Test
    fun `setKeywords ok`(){
        //GIVEN
        val sut = EnglishKeywordsRepository()

        //WHEN
        val result = sut.setKeywords()

        //THEN
        assertEquals(mapOf(Pair(Keywords.Keys.START, "Ohce"), Pair(Keywords.Keys.EXIT, "Stop!")), result)
    }


}