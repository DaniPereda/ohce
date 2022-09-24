package application

import domain.Day
import domain.Keywords
import domain.Ohce
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

class OhceServiceImplTest {

    private val mockClock = mock<Clock>()
    private val mockReader = mock<DataRetriever>()
    private val mockKeywords = mock<KeywordsRepository>()
    private val mockWriter = mock<AdaptOutput>()

    @Test
    fun `hello 20h Night`() {
        //GIVEN
        whenever(mockClock.retrieveHour()).thenReturn(20)
        whenever(mockReader.retrieveInputStr()).thenReturn("Ohce TesterName")
        whenever(mockKeywords.setKeywords()).thenReturn(mapOf(Pair(Keywords.Keys.START, "Ohce"), Pair(Keywords.Keys.EXIT, "Stop!")))
        val result = Ohce(mockReader.retrieveInputStr(), "", domain.Keywords(mockKeywords.setKeywords()))
        result.name = "TesterName"
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)

        //WHEN
        sut.analyzeNewWord()

        //THEN
        verify(mockWriter).adaptHello(result.name, Day.NIGHT)
    }

    @Test
    fun `normal word check`() {
        //GIVEN
        whenever(mockReader.retrieveInputStr()).thenReturn("helloDolly")
        whenever(mockKeywords.setKeywords()).thenReturn(mapOf(Pair(Keywords.Keys.START, "Ohce"), Pair(Keywords.Keys.EXIT, "Stop!")))
        val result = Ohce(mockReader.retrieveInputStr(), "", domain.Keywords(mockKeywords.setKeywords()))
        result.name = "TesterName"
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)
        sut.userName = "TesterName"

        //WHEN
        sut.analyzeNewWord()

        //THEN
        verify(mockWriter).adaptNormalWord("ylloDolleh")
    }

    @Test
    fun `palindrome word check`() {
        //GIVEN
        whenever(mockReader.retrieveInputStr()).thenReturn("uttopottu")
        whenever(mockKeywords.setKeywords()).thenReturn(mapOf(Pair(Keywords.Keys.START, "Ohce"), Pair(Keywords.Keys.EXIT, "Stop!")))
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)
        sut.userName = "TesterName"

        //WHEN
        sut.analyzeNewWord()

        //THEN
        verify(mockWriter).adaptPalindrome("uttopottu")
    }

    @Test
    fun `exit word check`() {
        //GIVEN
        whenever(mockReader.retrieveInputStr()).thenReturn("Stop!")
        whenever(mockKeywords.setKeywords()).thenReturn(mapOf(Pair(Keywords.Keys.START, "Ohce"), Pair(Keywords.Keys.EXIT, "Stop!")))
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)
        sut.userName = "TesterName"

        //WHEN
        sut.analyzeNewWord()

        //THEN
        verify(mockWriter).adaptBye("TesterName")
        assertEquals("", sut.userName)
    }

    @Test
    fun `hello but not the first`() {
        //GIVEN
        whenever(mockReader.retrieveInputStr()).thenReturn("Ohce pepe")
        whenever(mockKeywords.setKeywords()).thenReturn(mapOf(Pair(Keywords.Keys.START, "Ohce"), Pair(Keywords.Keys.EXIT, "Stop!")))
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)
        sut.userName = "TesterName"

        //WHEN
        sut.analyzeNewWord()

        //THEN
        verify(mockWriter).adaptNormalWord("epep echO")
    }

}