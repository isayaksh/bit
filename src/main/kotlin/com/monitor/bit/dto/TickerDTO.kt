package com.monitor.bit.dto

import com.monitor.bit.common.DateTimeFormats
import com.monitor.bit.domain.Ticker
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class TickerDTO(
    val market: String,
    val trade_date: String,
    val trade_time: String,
    val trade_date_kst: String,
    val trade_time_kst: String,
    val trade_timestamp: Long,
    val opening_price: Long,
    val high_price: Long,
    val low_price: Long,
    val trade_price: Long,
    val prev_closing_price: Long,
    val change: String,
    val change_price: Long,
    val change_rate: Double,
    val signed_change_price: Long,
    val signed_change_rate: Double,
    val trade_volume: Double,
    val acc_trade_price: Double,
    val acc_trade_price_24h: Double,
    val acc_trade_volume: Double,
    val acc_trade_volume_24h: Double,
    val highest_52_week_price: Long,
    val highest_52_week_date: String,
    val lowest_52_week_price: Long,
    val lowest_52_week_date: String,
    val timestamp: Long
) {

    fun toEntity(): Ticker {
        return Ticker(
            id = null,
            market = market,
            tradeDateTimeUtc = LocalDateTime.parse(trade_date + trade_time, DateTimeFormats.TICKER_FORMATTER),
            tradeDateTimeKst = LocalDateTime.parse(trade_date_kst + trade_time_kst, DateTimeFormats.TICKER_FORMATTER),
            tradeTimestamp = trade_timestamp,
            openingPrice = opening_price,
            highPrice = high_price,
            lowPrice = low_price,
            tradePrice = trade_price,
            prevClosingPrice = prev_closing_price,
            change = change,
            changePrice = change_price,
            changeRate = change_rate,
            signedChangePrice = signed_change_price,
            signedChangeRate = signed_change_rate,
            tradeVolume = trade_volume,
            accTradePrice = acc_trade_price,
            accTradePrice24h = acc_trade_price_24h,
            accTradeVolume = acc_trade_volume,
            accTradeVolume24h = acc_trade_volume_24h,
            highest52WeekPrice = highest_52_week_price,
            highest52WeekDate = highest_52_week_date,
            lowest52WeekPrice = lowest_52_week_price,
            lowest52WeekDate = lowest_52_week_date,
            timestamp = timestamp
        )
    }
}
