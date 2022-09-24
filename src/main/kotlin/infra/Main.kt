import application.OhceServiceImpl
import infra.ohceClock.ClockImpl
import infra.dataReader.ConsoleDataRetriever
import infra.keywords.EnglishKeywordsRepository
import infra.translatorAndDataOutput.SpanishAdapter

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    OhceServiceImpl(
        ConsoleDataRetriever(), SpanishAdapter(),
        ClockImpl(), EnglishKeywordsRepository()
    ).start()
}