package com.monitor.bit.service

import com.monitor.bit.domain.Candle
import com.monitor.bit.dto.CandleDTO
import com.monitor.bit.repository.CandleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.client.WebClient
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter


@Service
@Transactional(readOnly = true)
class CandleService(
    val webClient: WebClient,
    val candleRepository: CandleRepository
) {

    @Transactional
    fun insertCandles() {
        try {

            val candleList = webClient.get()
                .uri { uriBuilder ->
                    uriBuilder
                        .path("/v1/candles/seconds")
                        .queryParam("market", "KRW-BTC")
                        .build()
                }
                .retrieve()
                .bodyToFlux(CandleDTO::class.java)
                .map { it.toEntity() }
                .collectList()
                .block() ?: emptyList()

            println(candleList)

            candleRepository.saveAll<Candle>(candleList)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}