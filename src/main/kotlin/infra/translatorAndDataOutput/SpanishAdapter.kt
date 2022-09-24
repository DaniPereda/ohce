package infra.translatorAndDataOutput

import application.AdaptOutput
import domain.Day

class SpanishAdapter : AdaptOutput {
    val consolePrint = ConsolePrint()

    private val BUENOS_DIAS = "Buenos días"
    private val BUENAS_TARDES = "Buenos tardes"
    private val BUENOS_NOCHES = "Buenos noches"
    private val PALINDROME_PHRASE = "!Bonita palabra!"
    private val BYE_WORD = "Adios"


    override fun adaptHello(name: String, momentOfTheDay: Day) {

        consolePrint.printHello(translateMorningAfternoonNight(momentOfTheDay), name)
    }

    private fun translateMorningAfternoonNight(mornigAfternoonNight: Day) =
        when (mornigAfternoonNight) {
            Day.MORNING -> BUENOS_DIAS
            Day.AFTERNOON -> BUENAS_TARDES
            Day.NIGHT -> BUENOS_NOCHES
        }


    override fun adaptPalindrome(word: String) {
        consolePrint.printPalindrome(PALINDROME_PHRASE, word)
    }

    override fun adaptNormalWord(word: String) {
        consolePrint.printNormal(word)
    }

    override fun adaptBye(name: String) {
        consolePrint.printBye(BYE_WORD, name)
    }
}