package com.monitor.bit.common

import java.time.format.DateTimeFormatter

object DateTimeFormats {

    private const val TICKER_PATTERN = "yyyyMMddHHmmss"
    private const val TRADE_PATTERN = "yyyy-MM-dd HH:mm:ss"

    val TICKER_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern(TICKER_PATTERN)
    val TRADE_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern(TRADE_PATTERN)

}