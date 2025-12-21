package com.monitor.bit.writer

import com.monitor.bit.domain.Ticker
import com.monitor.bit.dto.TickerDTO
import com.monitor.bit.repository.TickerRepository
import org.springframework.batch.infrastructure.item.Chunk
import org.springframework.batch.infrastructure.item.ItemWriter
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class TickerItemWriter(
    private val webClient: WebClient,
    private val tickerRepository: TickerRepository
) : ItemWriter<String> {

    override fun write(items: Chunk<out String>) {
        if (items.isEmpty()) return

        val marketParam = items.joinToString(",")

        val tickers = webClient.get()
            .uri { uriBuilder ->
                uriBuilder
                    .path("/v1/ticker")
                    .queryParam("markets", marketParam)
                    .build()
            }
            .retrieve()
            .bodyToFlux(TickerDTO::class.java)
            .map { it.toEntity() }
            .collectList()
            .block() ?: emptyList()

        tickerRepository.saveAll(tickers)
    }
}