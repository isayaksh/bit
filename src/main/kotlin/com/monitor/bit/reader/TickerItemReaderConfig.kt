package com.monitor.bit.reader

import com.monitor.bit.repository.TradingPairRepository
import org.springframework.batch.infrastructure.item.data.RepositoryItemReader
import org.springframework.batch.infrastructure.item.data.builder.RepositoryItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.Sort

@Configuration
class TickerItemReaderConfig(
    private val tradingPairRepository: TradingPairRepository
) {

    @Bean
    fun tickerItemReader(): RepositoryItemReader<String> =
        RepositoryItemReaderBuilder<String>()
            .name("tickerItemReader")
            .repository(tradingPairRepository)
            .methodName("findAllByOrderByMarketAsc")
            .arguments(listOf<Any>())
            .sorts(mapOf("market" to Sort.Direction.ASC)) // 필수
            .pageSize(100)
            .build()

}