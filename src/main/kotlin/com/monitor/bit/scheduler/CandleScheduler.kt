package com.monitor.bit.scheduler

import com.monitor.bit.service.CandleService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class CandleScheduler(
    private val candleService: CandleService
) {

    @Scheduled(cron = "0 * * * * *")
    fun insertCandles() {
        candleService.insertCandles();
    }
}