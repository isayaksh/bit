package com.monitor.bit.service

import com.monitor.bit.domain.Candle
import com.monitor.bit.domain.Trade
import com.monitor.bit.dto.TradeDTO
import com.monitor.bit.repository.TradeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.client.WebClient

@Service
@Transactional(readOnly = true)
class TradeService(
    private val webClient: WebClient,
    private val tradeRepository: TradeRepository
) {

    @Transactional
    fun insertTrade() {
        try {

            val tradeList = webClient.get()
                .uri { uriBuilder ->
                    uriBuilder
                        .path("/v1/trades/ticks")
                        .queryParam("market", "KRW-BTC")
                        .build()
                }
                .retrieve()
                .bodyToFlux(TradeDTO::class.java)
                .map { it.toEntity() }
                .collectList()
                .block() ?: emptyList()

            println(tradeList)

            tradeRepository.saveAll<Trade>(tradeList)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}