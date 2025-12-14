package com.monitor.bit.scheduler

import com.monitor.bit.service.TradeService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class TradeScheduler(
    private val tradeService: TradeService
) {

    @Scheduled(cron = "0 * * * * *")
    fun insertTrades() {
        tradeService.insertTrade()
    }
}