package com.monitor.bit.reader

import com.monitor.bit.dto.TradingPairsDTO
import org.springframework.batch.infrastructure.item.ItemReader
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class TradingPairsReader(
    private val webClient: WebClient
): ItemReader<TradingPairsDTO> {

    override fun read(): TradingPairsDTO? {

        return webClient.get()
            .uri("/v1/market/all")
            .retrieve()
            .bodyToFlux(TradingPairsDTO::class.java)
            .blockFirst()
    }

}