package com.monitor.bit.dto

import com.monitor.bit.common.DateTimeFormats
import com.monitor.bit.domain.Trade
import java.time.LocalDateTime


data class TradeDTO(
    val market: String,
    val trade_date_utc: String,
    val trade_time_utc: String,
    val timestamp: Long,
    val trade_price: Double,
    val trade_volume: Double,
    val prev_closing_price: Double,
    val change_price: Double,
    val ask_bid: String,
    val sequential_id: Long
) {
    fun toEntity(): Trade {
        return Trade(
            market = this.market,
            tradeDateTimeUtc = LocalDateTime.parse("$trade_date_utc $trade_time_utc", DateTimeFormats.TRADE_FORMATTER),
            timestamp = this.timestamp,
            tradePrice = this.trade_price,
            tradeVolume = this.trade_volume,
            prevClosingPrice = this.prev_closing_price,
            changePrice = this.change_price,
            askBid = this.ask_bid,
            sequentialId = this.sequential_id
        )
    }
}