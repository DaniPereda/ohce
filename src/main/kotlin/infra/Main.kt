import application.OhceServiceImpl
import infra.ClockImpl
import infra.SpanishConsoleDataRetrieverPrimaryAdapter
import infra.EnglishKeywordsPort
import infra.SpanishConsolePrintSecondaryAdapter

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    OhceServiceImpl(SpanishConsoleDataRetrieverPrimaryAdapter(),SpanishConsolePrintSecondaryAdapter(),ClockImpl(),EnglishKeywordsPort()).startOhceService()
}