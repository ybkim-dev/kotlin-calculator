package io.domain

import history.entity.CalcResult

interface IO {
    fun printCalculationResult(result: Double);
    fun printHistories(histories: List<CalcResult>);
    fun getExpression(): String;
    fun getCommand() : Int;
}