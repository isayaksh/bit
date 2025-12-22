package com.monitor.bit.ticker.writer

import com.monitor.bit.domain.TradingPair
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
) : ItemWriter<TradingPair> {

    override fun write(chunk: Chunk<out TradingPair>) {
        // 1. Chunk에서 100개의 마켓 코드 추출 (예: "KRW-BTC,KRW-ETH...")
        val marketParam = chunk.items.joinToString(",") { it.market }

        // 2. 외부 API 호출 (100개 정보를 한 번에 가져옴)
        val tickerDtos = webClient.get()
            .uri { it.path("/v1/ticker").queryParam("markets", marketParam).build() }
            .retrieve()
            .bodyToFlux(TickerDTO::class.java)
            .collectList()
            .block() ?: emptyList()

        // 3. 결과 엔티티 변환 후 DB 일괄 저장
        val entities = tickerDtos.map { it.toEntity() }
        tickerRepository.saveAll(entities)
    }
}