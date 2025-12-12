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
class Ticker(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "market", nullable = false)
    val market: String,

    @Column(name = "trade_date_time_utc", nullable = false)
    val tradeDateTimeUtc: LocalDateTime,

    @Column(name = "trade_date_time_kst", nullable = false)
    val tradeDateTimeKst: LocalDateTime,

    @Column(name = "trade_timestamp", nullable = false)
    val tradeTimestamp: Long,

    @Column(name = "opening_price", nullable = false)
    val openingPrice: Long,

    @Column(name = "high_price", nullable = false)
    val highPrice: Long,

    @Column(name = "low_price", nullable = false)
    val lowPrice: Long,

    @Column(name = "trade_price", nullable = false)
    val tradePrice: Long,

    @Column(name = "prev_closing_price", nullable = false)
    val prevClosingPrice: Long,

    @Column(name = "change", nullable = false)
    val change: String,

    @Column(name = "change_price", nullable = false)
    val changePrice: Long,

    @Column(name = "change_rate", nullable = false)
    val changeRate: Double,

    @Column(name = "signed_change_price", nullable = false)
    val signedChangePrice: Long,

    @Column(name = "signed_change_rate", nullable = false)
    val signedChangeRate: Double,

    @Column(name = "trade_volume", nullable = false)
    val tradeVolume: Double,

    @Column(name = "acc_trade_price", nullable = false)
    val accTradePrice: Double,

    @Column(name = "acc_trade_price_24h", nullable = false)
    val accTradePrice24h: Double,

    @Column(name = "acc_trade_volume", nullable = false)
    val accTradeVolume: Double,

    @Column(name = "acc_trade_volume_24h", nullable = false)
    val accTradeVolume24h: Double,

    @Column(name = "highest_52_week_price", nullable = false)
    val highest52WeekPrice: Long,

    @Column(name = "highest_52_week_date", nullable = false)
    val highest52WeekDate: String,

    @Column(name = "lowest_52_week_price", nullable = false)
    val lowest52WeekPrice: Long,

    @Column(name = "lowest_52_week_date", nullable = false)
    val lowest52WeekDate: String,

    @Column(name = "timestamp", nullable = false)
    val timestamp: Long
)