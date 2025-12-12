package com.monitor.bit.common

import java.time.format.DateTimeFormatter

object DateTimeFormats {

    private const val TRADE_PATTERN = "yyyyMMddHHmmss"

    val TRADE_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern(TRADE_PATTERN)
}