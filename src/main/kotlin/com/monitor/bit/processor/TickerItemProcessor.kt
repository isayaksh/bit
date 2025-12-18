package com.monitor.bit.processor

import com.monitor.bit.domain.Ticker
import com.monitor.bit.dto.TickerDTO
import org.springframework.batch.infrastructure.item.ItemProcessor
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class TickerItemProcessor(
    private val webClient: WebClient
) : ItemProcessor<List<String>, List<Ticker>> {

    override fun process(markets: List<String>): List<Ticker> {
        val marketParam = markets.joinToString(",")

        return webClient.get()
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
    }
}