package com.monitor.bit.scheduler

import com.monitor.bit.dto.TradingPairsDTO
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class TradingPairsScheduler(
    val webClient: WebClient
) {

    fun updateTradingPairs() {
        val data = webClient.get()
            .uri("/v1/market/all")
            .retrieve()
            .bodyToFlux(TradingPairsDTO::class.java)
            .collectList()
            .block()
    }

}