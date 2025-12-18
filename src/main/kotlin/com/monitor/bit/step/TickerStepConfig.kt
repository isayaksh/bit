package com.monitor.bit.step


import com.monitor.bit.domain.Ticker
import com.monitor.bit.processor.TickerItemProcessor
import com.monitor.bit.reader.TickerItemReader
import com.monitor.bit.writer.TickerItemWriter
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.Step
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.batch.core.step.builder.StepBuilder

@Configuration
class TickerStepConfig(
    private val jobRepository: JobRepository,
    private val transactionManager: PlatformTransactionManager,
    private val reader: TickerItemReader,
    private val processor: TickerItemProcessor,
    private val writer: TickerItemWriter
) {

    @Bean
    fun tickerStep(): Step =
        StepBuilder("tickerStep", jobRepository)
            .chunk<List<String>, List<Ticker>>(1)      // 먼저 chunk
            .transactionManager(transactionManager)    // 그 다음
            .reader(reader)
            .processor(processor)
            .writer(writer)
            .build()

}
