package com.monitor.bit.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(
    name = "Candle",
    indexes = [
        Index(name = "idx_candle_market_time", columnList = "market, candle_time_kst")
    ]
)
class Candle(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, length = 20)
    val market: String,

    @Column(name = "candle_time_utc", nullable = false)
    val candleDateTimeUtc: LocalDateTime,

    @Column(name = "candle_time_kst", nullable = false)
    val candleDateTimeKst: LocalDateTime,

    @Column(name = "opening_price", nullable = false)
    val openingPrice: Double,

    @Column(name = "high_price", nullable = false)
    val highPrice: Double,

    @Column(name = "low_price", nullable = false)
    val lowPrice: Double,

    @Column(name = "trade_price", nullable = false)
    val tradePrice: Double,

    @Column(name = "timestamp", nullable = false)
    val timestamp: Long,

    @Column(name = "acc_trade_price", nullable = false)
    val candleAccTradePrice: Double,

    @Column(name = "acc_trade_volume", nullable = false)
    val candleAccTradeVolume: Double
) {
    protected constructor() : this(
        id = null,
        market = "",
        candleDateTimeUtc = LocalDateTime.now(),
        candleDateTimeKst = LocalDateTime.now(),
        openingPrice = 0.0,
        highPrice = 0.0,
        lowPrice = 0.0,
        tradePrice = 0.0,
        timestamp = 0L,
        candleAccTradePrice = 0.0,
        candleAccTradeVolume = 0.0
    )
}
