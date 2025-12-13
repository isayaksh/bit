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
    name = "candle",
    indexes = [
        Index(name = "idx_candle_market_time", columnList = "market, candle_date_time_utc")
    ]
)
class Candle protected constructor() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    @Column(nullable = false, length = 20)
    lateinit var market: String
        protected set

    @Column(name = "candle_date_time_utc", nullable = false)
    lateinit var candleDateTimeUtc: LocalDateTime
        protected set

    @Column(name = "candle_date_time_kst", nullable = false)
    lateinit var candleDateTimeKst: LocalDateTime
        protected set

    @Column(name = "opening_price", nullable = false)
    var openingPrice: Double = 0.0
        protected set

    @Column(name = "high_price", nullable = false)
    var highPrice: Double = 0.0
        protected set

    @Column(name = "low_price", nullable = false)
    var lowPrice: Double = 0.0
        protected set

    @Column(name = "trade_price", nullable = false)
    var tradePrice: Double = 0.0
        protected set

    @Column(name = "timestamp", nullable = false)
    var timestamp: Long = 0
        protected set

    @Column(name = "acc_trade_price", nullable = false)
    var candleAccTradePrice: Double = 0.0
        protected set

    @Column(name = "acc_trade_volume", nullable = false)
    var candleAccTradeVolume: Double = 0.0
        protected set

    companion object {
        fun create(
            market: String,
            candleDateTimeUtc: LocalDateTime,
            candleDateTimeKst: LocalDateTime,
            openingPrice: Double,
            highPrice: Double,
            lowPrice: Double,
            tradePrice: Double,
            timestamp: Long,
            candleAccTradePrice: Double,
            candleAccTradeVolume: Double
        ): Candle {
            val c = Candle()
            c.market = market
            c.candleDateTimeUtc = candleDateTimeUtc
            c.candleDateTimeKst = candleDateTimeKst
            c.openingPrice = openingPrice
            c.highPrice = highPrice
            c.lowPrice = lowPrice
            c.tradePrice = tradePrice
            c.timestamp = timestamp
            c.candleAccTradePrice = candleAccTradePrice
            c.candleAccTradeVolume = candleAccTradeVolume
            return c
        }
    }
}
