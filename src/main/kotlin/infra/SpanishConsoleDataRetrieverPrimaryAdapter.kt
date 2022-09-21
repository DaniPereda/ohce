package infra

import application.DataRetrieverPrimaryAdapter

class SpanishConsoleDataRetrieverPrimaryAdapter:DataRetrieverPrimaryAdapter {
    override fun retrieveName(): String {
        return readln()
    }

    override fun retrieveWord(): String {
        return readln()
    }
}