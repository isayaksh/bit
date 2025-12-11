package com.monitor.bit.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.*
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "trade")
class Trade(

    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, length = 20)
    val market: String,

    @Column(nullable = false,)
    val tradeDateUtc: LocalDateTime,

    @Column(nullable = false)
    val tradeTimeUtc: LocalDateTime,

    @Column(nullable = false)
    val timestamp: Long,

    @Column(nullable = false)
    val tradePrice: Double,

    @Column(nullable = false)
    val tradeVolume: Double,

    @Column(nullable = false)
    val prevClosingPrice: Double,

    @Column(nullable = false)
    val changePrice: Double,

    @Column(nullable = false, length = 3)
    val askBid: String,

    @Column(nullable = false)
    val sequentialId: Long
)