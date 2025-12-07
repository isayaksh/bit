package com.monitor.bit.repository

import com.monitor.bit.domain.TradingPair
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TradingPairRepository: JpaRepository<TradingPair, Long> {
}