package com.monitor.bit.repository

import com.monitor.bit.domain.Candle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CandleRepository: JpaRepository<Candle, Long> {
}