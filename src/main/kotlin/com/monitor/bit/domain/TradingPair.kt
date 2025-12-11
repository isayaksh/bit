package com.monitor.bit.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.Table

@Entity
@Table(
    name = "TradingPair",
    indexes = [
        Index(name = "idx_trading_pair_market", columnList = "market")
    ]
)
class TradingPair(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,   // PK는 nullable로 둬야 Hibernate가 insert할 때 auto-increment 가능

    @Column(name = "market", nullable = false, length = 50)
    var market: String,

    @Column(name = "korean_name", nullable = false, length = 100)
    var koreanName: String,

    @Column(name = "english_name", nullable = false, length = 100)
    var englishName: String

) {
    // JPA가 사용할 기본 생성자(파라미터 없는 생성자)는 꼭 필요 → protected로 감추는 것이 정석
    protected constructor() : this(
        id = null,
        market = "",
        koreanName = "",
        englishName = ""
    )
}