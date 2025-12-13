package com.monitor.bit.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(
    name = "ticker",
    indexes = [
        Index(name = "idx_ticker_market_trade_date_time", columnList = "market, trade_date_time_utc")
    ]
)
class Ticker protected constructor() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    @Column(name = "market", nullable = false)
    lateinit var market: String
        protected set

    @Column(name = "trade_date_time_utc", nullable = false)
    lateinit var tradeDateTimeUtc: LocalDateTime
        protected set

    @Column(name = "trade_date_time_kst", nullable = false)
    lateinit var tradeDateTimeKst: LocalDateTime
        protected set

    @Column(name = "trade_timestamp", nullable = false)
    var tradeTimestamp: Long = 0
        protected set

    @Column(name = "opening_price", nullable = false)
    var openingPrice: Long = 0
        protected set

    @Column(name = "high_price", nullable = false)
    var highPrice: Long = 0
        protected set

    @Column(name = "low_price", nullable = false)
    var lowPrice: Long = 0
        protected set

    @Column(name = "trade_price", nullable = false)
    var tradePrice: Long = 0
        protected set

    @Column(name = "prev_closing_price", nullable = false)
    var prevClosingPrice: Long = 0
        protected set

    @Column(name = "change", nullable = false)
    lateinit var change: String
        protected set

    @Column(name = "change_price", nullable = false)
    var changePrice: Long = 0
        protected set

    @Column(name = "change_rate", nullable = false)
    var changeRate: Double = 0.0
        protected set

    @Column(name = "signed_change_price", nullable = false)
    var signedChangePrice: Long = 0
        protected set

    @Column(name = "signed_change_rate", nullable = false)
    var signedChangeRate: Double = 0.0
        protected set

    @Column(name = "trade_volume", nullable = false)
    var tradeVolume: Double = 0.0
        protected set

    @Column(name = "acc_trade_price", nullable = false)
    var accTradePrice: Double = 0.0
        protected set

    @Column(name = "acc_trade_price_24h", nullable = false)
    var accTradePrice24h: Double = 0.0
        protected set

    @Column(name = "acc_trade_volume", nullable = false)
    var accTradeVolume: Double = 0.0
        protected set

    @Column(name = "acc_trade_volume_24h", nullable = false)
    var accTradeVolume24h: Double = 0.0
        protected set

    @Column(name = "highest_52_week_price", nullable = false)
    var highest52WeekPrice: Long = 0
        protected set

    @Column(name = "highest_52_week_date", nullable = false)
    lateinit var highest52WeekDate: String
        protected set

    @Column(name = "lowest_52_week_price", nullable = false)
    var lowest52WeekPrice: Long = 0
        protected set

    @Column(name = "lowest_52_week_date", nullable = false)
    lateinit var lowest52WeekDate: String
        protected set

    @Column(name = "timestamp", nullable = false)
    var timestamp: Long = 0
        protected set

    companion object {
        fun create(
            market: String,
            tradeDateTimeUtc: LocalDateTime,
            tradeDateTimeKst: LocalDateTime,
            tradeTimestamp: Long,
            openingPrice: Long,
            highPrice: Long,
            lowPrice: Long,
            tradePrice: Long,
            prevClosingPrice: Long,
            change: String,
            changePrice: Long,
            changeRate: Double,
            signedChangePrice: Long,
            signedChangeRate: Double,
            tradeVolume: Double,
            accTradePrice: Double,
            accTradePrice24h: Double,
            accTradeVolume: Double,
            accTradeVolume24h: Double,
            highest52WeekPrice: Long,
            highest52WeekDate: String,
            lowest52WeekPrice: Long,
            lowest52WeekDate: String,
            timestamp: Long
        ): Ticker {
            val t = Ticker()
            t.market = market
            t.tradeDateTimeUtc = tradeDateTimeUtc
            t.tradeDateTimeKst = tradeDateTimeKst
            t.tradeTimestamp = tradeTimestamp
            t.openingPrice = openingPrice
            t.highPrice = highPrice
            t.lowPrice = lowPrice
            t.tradePrice = tradePrice
            t.prevClosingPrice = prevClosingPrice
            t.change = change
            t.changePrice = changePrice
            t.changeRate = changeRate
            t.signedChangePrice = signedChangePrice
            t.signedChangeRate = signedChangeRate
            t.tradeVolume = tradeVolume
            t.accTradePrice = accTradePrice
            t.accTradePrice24h = accTradePrice24h
            t.accTradeVolume = accTradeVolume
            t.accTradeVolume24h = accTradeVolume24h
            t.highest52WeekPrice = highest52WeekPrice
            t.highest52WeekDate = highest52WeekDate
            t.lowest52WeekPrice = lowest52WeekPrice
            t.lowest52WeekDate = lowest52WeekDate
            t.timestamp = timestamp
            return t
        }
    }
}
