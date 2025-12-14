package com.monitor.bit.service

import com.monitor.bit.domain.Candle
import com.monitor.bit.dto.CandleDTO
import com.monitor.bit.repository.CandleRepository
import com.monitor.bit.repository.TradingPairRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.client.WebClient


@Service
@Transactional(readOnly = true)
class CandleService(
    private val webClient: WebClient,
    private val candleRepository: CandleRepository,
    private val tradingPairRepository: TradingPairRepository
) {

    fun insertCandles() {
        tradingPairRepository.findAll()
            .map { it.market }                      // List<String>
            .map { fetchCandle(it) }       // List<List<Candle>>
            .filter { it.isNotEmpty() }
            .forEach { saveCandle(it) }
    }

    // 1. 외부 API 호출
    fun fetchCandle(market: String): List<Candle> {
        return webClient.get()
            .uri { uriBuilder ->
                uriBuilder
                    .path("/v1/candles/minutes/1")
                    .queryParam("market", market)
                    .build()
            }
            .retrieve()
            .bodyToFlux(CandleDTO::class.java)
            .map { it.toEntity() }
            .collectList()
            .block() ?: emptyList()
    }

    // 2. DB 저장
    @Transactional
    fun saveCandle(candleList: List<Candle>) {
        candleRepository.saveAll<Candle>(candleList)
    }

}