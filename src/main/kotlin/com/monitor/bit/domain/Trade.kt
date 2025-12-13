package com.monitor.bit.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(
    name = "trade",
    indexes = [
        Index(
            name = "idx_trade_market_trade_date_time",
            columnList = "market, trade_date_time_utc"
        )
    ]
)
class Trade protected constructor() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    @Column(name = "market", nullable = false, length = 20)
    lateinit var market: String
        protected set

    @Column(name = "trade_date_time_utc", nullable = false)
    lateinit var tradeDateTimeUtc: LocalDateTime
        protected set

    @Column(name = "timestamp", nullable = false)
    var timestamp: Long = 0
        protected set

    @Column(name = "trade_price", nullable = false)
    var tradePrice: Double = 0.0
        protected set

    @Column(name = "trade_volume", nullable = false)
    var tradeVolume: Double = 0.0
        protected set

    @Column(name = "pre_closing_price", nullable = false)
    var prevClosingPrice: Double = 0.0
        protected set

    @Column(name = "change_price", nullable = false)
    var changePrice: Double = 0.0
        protected set

    @Column(name = "ask_bid", nullable = false, length = 3)
    lateinit var askBid: String
        protected set

    @Column(name = "sequential_id", nullable = false)
    var sequentialId: Long = 0
        protected set

    companion object {
        fun create(
            market: String,
            tradeDateTimeUtc: LocalDateTime,
            timestamp: Long,
            tradePrice: Double,
            tradeVolume: Double,
            prevClosingPrice: Double,
            changePrice: Double,
            askBid: String,
            sequentialId: Long
        ): Trade {
            val t = Trade()
            t.market = market
            t.tradeDateTimeUtc = tradeDateTimeUtc
            t.timestamp = timestamp
            t.tradePrice = tradePrice
            t.tradeVolume = tradeVolume
            t.prevClosingPrice = prevClosingPrice
            t.changePrice = changePrice
            t.askBid = askBid
            t.sequentialId = sequentialId
            return t
        }
    }
}
