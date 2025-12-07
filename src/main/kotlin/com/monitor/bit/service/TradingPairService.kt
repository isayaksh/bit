package com.monitor.bit.service

import com.monitor.bit.domain.TradingPair
import com.monitor.bit.dto.TradingPairsDTO
import com.monitor.bit.repository.TradingPairRepository
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import kotlin.text.get

@Service
class TradingPairService(
    val webClient: WebClient,
    val tradingPairRepository: TradingPairRepository
) {
    fun insertTradingPairs() {

        try {
            val tradingPairList = webClient.get()
                .uri("/v1/market/all")
                .retrieve()
                .bodyToFlux(TradingPairsDTO::class.java)
                .map { it.toEntity() }
                .collectList()
                .block() ?: emptyList()

            val savedTradingPairs = tradingPairRepository.saveAll<TradingPair>(tradingPairList)

        } catch (e: Exception) {

        }

    }
}