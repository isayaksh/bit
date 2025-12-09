package com.monitor.bit.scheduler

import com.monitor.bit.service.TradeService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class TradeScheduler(
    val tradeService: TradeService
) {

    @Scheduled(cron = "* * * * * *")
    fun insertTrades() {
        tradeService.insertTrade()
    }
}