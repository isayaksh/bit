package com.monitor.bit.scheduler

import com.monitor.bit.dto.TradingPairsDTO
import com.monitor.bit.service.TradingPairService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class TradingPairsScheduler(
    private val tradingPairService: TradingPairService
) {

    @Scheduled(cron = "0 0 0 * * *") // 매일 00시 00분 00초에 실행함.
    fun updateTradingPairs() {
        tradingPairService.insertTradingPairs()
    }

}