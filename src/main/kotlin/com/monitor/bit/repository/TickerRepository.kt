package com.monitor.bit.repository

import com.monitor.bit.domain.Ticker
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TickerRepository: JpaRepository<Ticker, Long> {
}