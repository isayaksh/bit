package com.monitor.bit.dto

import com.monitor.bit.domain.Candle
import java.time.LocalDateTime

data class CandleDTO(
    val market: String,
    val candle_date_time_utc: String,
    val candle_date_time_kst: String,
    val opening_price: Double?,
    val high_price: Double?,
    val low_price: Double?,
    val trade_price: Double?,
    val timestamp: Long,
    val candle_acc_trade_price: Double?,
    val candle_acc_trade_volume: Double?
) {
    fun toEntity(): Candle {
        return Candle(
            market = market,
            candleDateTimeUtc = LocalDateTime.parse(candle_date_time_utc),
            candleDateTimeKst = LocalDateTime.parse(candle_date_time_kst),
            openingPrice = opening_price ?: 0.0,
            highPrice = high_price ?: 0.0,
            lowPrice = low_price ?: 0.0,
            tradePrice = trade_price ?: 0.0,
            timestamp = timestamp,
            candleAccTradePrice = candle_acc_trade_price ?: 0.0,
            candleAccTradeVolume = candle_acc_trade_volume ?: 0.0
        )
    }
}
