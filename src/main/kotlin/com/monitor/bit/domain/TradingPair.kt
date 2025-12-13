package com.monitor.bit.domain

import jakarta.persistence.*

@Entity
@Table(
    name = "TradingPair",
    indexes = [
        Index(name = "idx_trading_pair_market", columnList = "market")
    ]
)
class TradingPair protected constructor() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    @Column(name = "market", nullable = false, length = 50)
    lateinit var market: String
        protected set

    @Column(name = "korean_name", nullable = false, length = 100)
    lateinit var koreanName: String
        protected set

    @Column(name = "english_name", nullable = false, length = 100)
    lateinit var englishName: String
        protected set

    companion object {
        fun create(
            market: String,
            koreanName: String,
            englishName: String
        ): TradingPair {
            val p = TradingPair()
            p.market = market
            p.koreanName = koreanName
            p.englishName = englishName
            return p
        }
    }
}
