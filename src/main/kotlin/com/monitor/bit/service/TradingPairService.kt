package com.monitor.bit.service

import com.monitor.bit.domain.TradingPair
import com.monitor.bit.dto.TradingPairsDTO
import com.monitor.bit.repository.TradingPairRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.client.WebClient
import kotlin.text.get

@Service
@Transactional(readOnly = true)
class TradingPairService(
    val webClient: WebClient,
    val tradingPairRepository: TradingPairRepository
) {
    @Transactional
    fun insertTradingPairs() {
        try {
            val tradingPairList = webClient.get()
                .uri("/v1/market/all")
                .retrieve()
                .bodyToFlux(TradingPairsDTO::class.java)
                .map { it.toEntity() }
                .collectList()
                .block() ?: emptyList()

            tradingPairRepository.saveAll<TradingPair>(tradingPairList)

        } catch (e: Exception) {

        }
    }
}