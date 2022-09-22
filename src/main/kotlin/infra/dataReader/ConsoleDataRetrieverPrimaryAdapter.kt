package infra.dataReader

import application.DataRetrieverPrimaryAdapter

class ConsoleDataRetrieverPrimaryAdapter:DataRetrieverPrimaryAdapter {
    override fun retrieveName(): String {
        return readln()
    }

    override fun retrieveWord(): String {
        return readln()
    }
}