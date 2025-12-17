package com.monitor.bit.reader

import com.monitor.bit.repository.TradingPairRepository
import org.springframework.batch.infrastructure.item.ItemReader
import org.springframework.stereotype.Component

@Component
class TickerReader(
    private val tradingPairRepository: TradingPairRepository
): ItemReader<List<String>> {

    private var index = 0
    private val markets: List<String> by lazy {
        tradingPairRepository.findAll().map { it.market }
    }

    override fun read(): List<String>? {
        if (index >= markets.size) return null

        val chunk = markets.drop(index).take(100)
        index += 100
        return chunk
    }

}