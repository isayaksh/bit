package com.monitor.bit.service

import com.monitor.bit.domain.Candle
import com.monitor.bit.domain.Ticker
import com.monitor.bit.domain.Trade
import com.monitor.bit.dto.TickerDTO
import com.monitor.bit.dto.TradeDTO
import com.monitor.bit.repository.TickerRepository
import com.monitor.bit.repository.TradingPairRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.client.WebClient

@Service
@Transactional(readOnly = true)
class TickerService(
    private val webClient: WebClient,
    private val tickerRepository: TickerRepository,
    private val tradingPairRepository: TradingPairRepository
) {

    fun insertTicker() {

        val marketList = tradingPairRepository.findAll()
            .map { it.market }

        // 414 URI Too Long을 피하기 위해 100개씩 분리하여 요청
        marketList.chunked(100).forEach { chunk ->
            val markets = chunk.joinToString(",")
            val tickerList = fetchTicker(markets)
            saveCandle(tickerList)
        }

    }

    // 1. 외부 API 호출
    fun fetchTicker(markets: String): List<Ticker> {
        return webClient.get()
            .uri { uriBuilder ->
                uriBuilder
                    .path("/v1/ticker")
                    .queryParam("markets", markets)
                    .build()
            }
            .retrieve()
            .bodyToFlux(TickerDTO::class.java)
            .map { it.toEntity() }
            .collectList()
            .block() ?: emptyList()
    }

    // 2. DB 저장
    @Transactional
    fun saveCandle(tickerList: List<Ticker>) {
        tickerRepository.saveAll<Ticker>(tickerList)
    }

}