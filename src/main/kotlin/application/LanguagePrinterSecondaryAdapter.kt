package application

import domain.Ohce


interface LanguagePrinterSecondaryAdapter {
    fun printHello(ohce:Ohce)

    fun printPalindrome(word:String)

    fun printNormalWord(word:String)

    fun printBye(name:String)
}