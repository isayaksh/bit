package com.monitor.bit.reader

import com.monitor.bit.repository.TradingPairRepository
import org.springframework.batch.infrastructure.item.data.RepositoryItemReader
import org.springframework.batch.infrastructure.item.data.builder.RepositoryItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TradingPairReaderConfig (
    private val tradingPairRepository: TradingPairRepository
) {

    @Bean
    fun tradingPairMarketReader(): RepositoryItemReader<String> {
        return RepositoryItemReaderBuilder<String>()
            .name("tradingPairMarketReader")
            .repository(tradingPairRepository)
            .methodName("findMarketOnly")
            .pageSize(100)
            .build()
    }
}