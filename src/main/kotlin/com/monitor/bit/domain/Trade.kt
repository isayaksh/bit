package com.monitor.bit.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.*
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(
    name = "trade",
    indexes = [
        Index(name = "idx_trade_market_trade_date_time", columnList = "market, trade_date_utc, trade_time_utc")
    ]
)
class Trade(

    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,

    @Column(name = "market", nullable = false, length = 20)
    val market: String,

    @Column(name = "trade_date_utc", nullable = false)
    val tradeDateUtc: LocalDateTime,

    @Column(name = "trade_time_utc", nullable = false)
    val tradeTimeUtc: LocalDateTime,

    @Column(name = "timestamp", nullable = false)
    val timestamp: Long,

    @Column(name = "trade_price", nullable = false)
    val tradePrice: Double,

    @Column(name = "trade_volume", nullable = false)
    val tradeVolume: Double,

    @Column(name = "pre_closing_price", nullable = false)
    val prevClosingPrice: Double,

    @Column(name = "change_price", nullable = false)
    val changePrice: Double,

    @Column(name = "ask_bid", nullable = false, length = 3)
    val askBid: String,

    @Column(name = "sequential_id", nullable = false)
    val sequentialId: Long
)