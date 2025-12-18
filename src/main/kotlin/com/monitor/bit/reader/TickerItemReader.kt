package com.monitor.bit.reader

import com.monitor.bit.repository.TradingPairRepository
import org.springframework.batch.infrastructure.item.ItemReader
import org.springframework.stereotype.Component

@Component
class TickerItemReader(
    tradingPairRepository: TradingPairRepository
) : ItemReader<List<String>> {

    private val iterator: Iterator<List<String>> =
        tradingPairRepository.findAll()
            .map { it.market }
            .chunked(100)
            .iterator()

    override fun read(): List<String>? =
        if (iterator.hasNext()) iterator.next() else null
}