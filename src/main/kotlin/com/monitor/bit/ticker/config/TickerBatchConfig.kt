package com.monitor.bit.ticker.config

import com.monitor.bit.domain.TradingPair
import com.monitor.bit.ticker.writer.TickerItemWriter
import org.springframework.batch.core.job.Job
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.job.parameters.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.Step
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.infrastructure.item.ItemReader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager


@Configuration
class TickerBatchConfig(
    private val jobRepository: JobRepository,
    private val transactionManager: PlatformTransactionManager,
    private val tickerItemReader: ItemReader<TradingPair>,
    private val tickerItemWriter: TickerItemWriter
) {

    @Bean
    fun tickerJob(): Job {
        return JobBuilder("tickerJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(tickerStep())
            .build()
    }

    @Bean
    fun tickerStep(): Step {
        return StepBuilder("tickerStep", jobRepository)
            .reader(tickerItemReader) // Reader를 먼저 넣어서 타입을 결정시킴
            .writer(tickerItemWriter) // Writer를 넣음
            .chunk<TradingPair, TradingPair>(100, transactionManager) // 그 다음 chunk 설정
            .build()
    }
}