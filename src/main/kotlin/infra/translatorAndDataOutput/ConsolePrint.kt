package infra.translatorAndDataOutput

import application.AdaptOutput
import application.Output
import domain.Day
import domain.Ohce

class ConsolePrint : Output {
    override fun printHello(helloWord: String, name: String) {
        println("$helloWord $name")
    }

    override fun printPalindrome(palindromePhrase: String, word: String) {
        println(word)
        println(palindromePhrase)
    }

    override fun printNormal(word: String) {
        println(word)
    }

    override fun printBye(byeWord: String, name: String) {
        println("$byeWord $name")
    }

}