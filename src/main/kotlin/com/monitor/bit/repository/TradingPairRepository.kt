package com.monitor.bit.repository

import com.monitor.bit.domain.TradingPair
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TradingPairRepository: JpaRepository<TradingPair, Long> {

    @Query("select t.market from TradingPair t")
    fun findAllMarketOnly(pageable: Pageable): List<String>

}