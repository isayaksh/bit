package com.monitor.bit.dto


data class TradeDto(
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
)