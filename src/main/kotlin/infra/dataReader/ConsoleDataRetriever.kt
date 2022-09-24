package infra.dataReader

import application.DataRetriever

class ConsoleDataRetriever:DataRetriever {
    override fun retrieveInputStr(): String {
        return readln()
    }

}