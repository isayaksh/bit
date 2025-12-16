package com.monitor.bit.service

import com.monitor.bit.domain.Candle
import com.monitor.bit.domain.Trade
import com.monitor.bit.dto.TradeDTO
import com.monitor.bit.repository.TradeRepository
import com.monitor.bit.repository.TradingPairRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.client.WebClient

@Service
@Transactional(readOnly = true)
class TradeService(
    private val webClient: WebClient,
    private val tradeRepository: TradeRepository,
    private val tradingPairRepository: TradingPairRepository
) {

    @Transactional
    fun insertTrade() {
        tradingPairRepository.findAll()
            .map { it.market }                      // List<String>
            .map { fetchTrade(it) }        // List<List<Candle>>
            .filter { it.isNotEmpty() }
            .forEach { saveCandle(it) }
    }

    // 1. 외부 API 호출
    fun fetchTrade(market: String): List<Trade> {
        return webClient.get()
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
    }

    // 2. DB 저장
    @Transactional
    fun saveCandle(tradeList: List<Trade>) {
        tradeRepository.saveAll<Trade>(tradeList)
    }

}