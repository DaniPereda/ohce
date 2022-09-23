package infra.dataReader

import application.DataRetrieverPrimaryAdapter

class ConsoleDataRetrieverPrimaryAdapter:DataRetrieverPrimaryAdapter {
    override fun retrieveInputStr(): String {
        return readln()
    }

}