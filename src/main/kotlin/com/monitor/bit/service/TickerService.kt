package com.monitor.bit.service

import com.monitor.bit.domain.Ticker
import com.monitor.bit.domain.Trade
import com.monitor.bit.dto.TickerDTO
import com.monitor.bit.dto.TradeDTO
import com.monitor.bit.repository.TickerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.client.WebClient

@Service
@Transactional(readOnly = true)
class TickerService(
    private val webClient: WebClient,
    private val tickerRepository: TickerRepository
) {

    @Transactional
    fun insertTicker() {
        try {

            val tickerList = webClient.get()
                .uri { uriBuilder ->
                    uriBuilder
                        .path("/v1/ticker")
                        .queryParam("markets", "KRW-BTC")
                        .build()
                }
                .retrieve()
                .bodyToFlux(TickerDTO::class.java)
                .map { it.toEntity() }
                .collectList()
                .block() ?: emptyList()

            tickerRepository.saveAll<Ticker>(tickerList)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}