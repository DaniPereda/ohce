package application

import domain.Day
import domain.Ohce
import domain.Status
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

class OhceServiceImplTest {

    private val mockClock = mock<Clock>()
    private val mockReader = mock<DataRetrieverPrimaryAdapter>()
    private val mockKeywords = mock<KeywordsPort>()
    private val mockWriter = mock<LanguagePrinterSecondaryAdapter>()

    @Test
    fun `hello 20h`() {
        //GIVEN
        whenever(mockClock.retrieveHour()).thenReturn(20)
        whenever(mockReader.retrieveName()).thenReturn("TesterName")
        val result = Ohce(name = "TesterName", status = Status.HELLO, dayMoment = Day.NIGHT)
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)

        //WHEN
        sut.analyzeFirstWord()

        //THEN
        verify(mockWriter).printHello(result)
    }

    @Test
    fun `hello 5h`() {
        //GIVEN
        whenever(mockClock.retrieveHour()).thenReturn(5)
        whenever(mockReader.retrieveName()).thenReturn("TesterName")
        val result = Ohce(name = "TesterName", status = Status.HELLO, dayMoment = Day.NIGHT)
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)

        //WHEN
        sut.analyzeFirstWord()

        //THEN
        verify(mockWriter).printHello(result)
    }

    @Test
    fun `hello 6h`() {
        //GIVEN
        whenever(mockClock.retrieveHour()).thenReturn(6)
        whenever(mockReader.retrieveName()).thenReturn("TesterName")
        val result = Ohce(name = "TesterName", status = Status.HELLO, dayMoment = Day.MORNING)
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)

        //WHEN
        sut.analyzeFirstWord()

        //THEN
        verify(mockWriter).printHello(result)
    }

    @Test
    fun `hello 11h`() {
        //GIVEN
        whenever(mockClock.retrieveHour()).thenReturn(11)
        whenever(mockReader.retrieveName()).thenReturn("TesterName")
        val result = Ohce(name = "TesterName", status = Status.HELLO, dayMoment = Day.MORNING)
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)

        //WHEN
        sut.analyzeFirstWord()

        //THEN
        verify(mockWriter).printHello(result)
    }

    @Test
    fun `hello 12h`() {
        //GIVEN
        whenever(mockClock.retrieveHour()).thenReturn(12)
        whenever(mockReader.retrieveName()).thenReturn("TesterName")
        val result = Ohce(name = "TesterName", status = Status.HELLO, dayMoment = Day.AFTERNOON)
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)

        //WHEN
        sut.analyzeFirstWord()

        //THEN
        verify(mockWriter).printHello(result)
    }

    @Test
    fun `hello 19h`() {
        //GIVEN
        whenever(mockClock.retrieveHour()).thenReturn(19)
        whenever(mockReader.retrieveName()).thenReturn("TesterName")
        val result = Ohce(name = "TesterName", status = Status.HELLO, dayMoment = Day.AFTERNOON)
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)

        //WHEN
        sut.analyzeFirstWord()

        //THEN
        verify(mockWriter).printHello(result)
    }

    @Test
    fun `assert Returned Name`() {
        //GIVEN
        whenever(mockClock.retrieveHour()).thenReturn(19)
        whenever(mockReader.retrieveName()).thenReturn("TesterName")
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)

        //WHEN
        val result = sut.analyzeFirstWord()

        //THEN
        assertEquals("TesterName", result)
    }

    @Test
    fun `normal Word`(){
        val wordToTest = "miPalabra"
        whenever(mockReader.retrieveWord()).thenReturn(wordToTest)
        whenever(mockKeywords.isStopKeyword(wordToTest)).thenReturn(false)
        val result = "arbalaPim"
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)
        sut.userName = "TesterName"

        //WHEN
        sut.analyzeNewWord()

        //THEN
        verify(mockWriter).printNormalWord(result)
    }

    @Test
    fun `palindrome Word`(){
        val wordToTest = "sacas"
        whenever(mockReader.retrieveWord()).thenReturn(wordToTest)
        whenever(mockKeywords.isStopKeyword(wordToTest)).thenReturn(false)
        val result = "sacas"
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)
        sut.userName = "TesterName"

        //WHEN
        sut.analyzeNewWord()

        //THEN
        verify(mockWriter).printPalindrome(result)
    }

    @Test
    fun `Exit Word`(){
        val wordToTest = "Stop!"
        whenever(mockReader.retrieveWord()).thenReturn(wordToTest)
        whenever(mockKeywords.isStopKeyword(wordToTest)).thenReturn(true)
        val sut = OhceServiceImpl(mockReader, mockWriter, mockClock, mockKeywords)
        sut.userName = "TesterName"

        //WHEN
        sut.analyzeNewWord()

        //THEN
        verify(mockWriter).printBye("TesterName")
    }
}