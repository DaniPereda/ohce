package infra.translatorAndDataOutput

import application.LanguagePrinterSecondaryAdapter
import domain.Day
import domain.Ohce

class SpanishConsolePrintSecondaryAdapter : LanguagePrinterSecondaryAdapter {
    override fun printHello(ohce: Ohce, momentOfTheDay:Day) {

       println("${translateMorningAfternoonNight(momentOfTheDay)} ${ohce.name}")
    }

    private fun translateMorningAfternoonNight(mornigAfternoonNight: Day) =
        when (mornigAfternoonNight) {
            Day.MORNING -> "Buenos días"
            Day.AFTERNOON -> "Buenas tardes"
            Day.NIGHT -> "Buenas noches"
        }


    override fun printPalindrome(word: String) {
        println(word)
        println("!Bonita palabra!")
    }

    override fun printNormalWord(word: String) {
        println(word)
    }

    override fun printBye(name: String) {
        println("Adios $name")
    }
}