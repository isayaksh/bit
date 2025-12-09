package com.monitor.bit.repository

import com.monitor.bit.domain.Trade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TradeRepository: JpaRepository<Trade, Long> {
}