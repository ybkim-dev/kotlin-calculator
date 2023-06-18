package io.domain

import history.entity.CalcResult
import message.MessageUtil
import java.io.BufferedReader
import java.io.InputStreamReader

class ConsoleIO : IO {
    private val reader: BufferedReader = BufferedReader(InputStreamReader(System.`in`))

    override fun printCalculationResult(result: Double) {
        println(result)
    }

    override fun printHistories(histories: List<CalcResult>) {
        histories.forEach { println(it) }
    }

    override fun getExpression(): String {
        return reader.readLine()
    }

    override fun getCommand() : Int {
        val commandMenuMessage = MessageUtil.getCommandMenuMessage()
        println(commandMenuMessage)
        return Integer.parseInt(reader.readLine())
    }
}