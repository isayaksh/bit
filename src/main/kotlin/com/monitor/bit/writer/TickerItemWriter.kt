package com.monitor.bit.writer

import com.monitor.bit.domain.Ticker
import com.monitor.bit.repository.TickerRepository
import org.springframework.batch.infrastructure.item.Chunk
import org.springframework.batch.infrastructure.item.ItemWriter
import org.springframework.stereotype.Component

@Component
class TickerItemWriter(
    private val tickerRepository: TickerRepository
) : ItemWriter<List<Ticker>> {

    override fun write(items: Chunk<out List<Ticker>>) {
        items.flatten().let {
            tickerRepository.saveAll(it)
        }
    }

}