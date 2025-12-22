package com.monitor.bit.ticker.reader

import com.monitor.bit.domain.TradingPair
import com.monitor.bit.repository.TradingPairRepository
import org.springframework.batch.infrastructure.item.ItemReader
import org.springframework.batch.infrastructure.item.data.builder.RepositoryItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.Sort

@Configuration
class TickerReaderConfig(
    private val tradingPairRepository: TradingPairRepository
) {
    @Bean
    fun tickerItemReader(): ItemReader<TradingPair> { // RepositoryItemReader가 아닌 ItemReader로 반환
        return RepositoryItemReaderBuilder<TradingPair>()
            .name("tickerItemReader")
            .repository(tradingPairRepository)
            .methodName("findAll")
            .pageSize(100)
            .sorts(mapOf("id" to Sort.Direction.ASC))
            .build()
    }
}