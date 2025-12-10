package com.monitor.bit.scheduler

import com.monitor.bit.service.TickerService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class TickerScheduler(
    private val tickerService: TickerService
) {

    @Scheduled(cron = "* * * * * *")
    fun insertTickers() {
        tickerService.insertTicker()
    }

}