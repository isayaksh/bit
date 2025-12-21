package com.monitor.bit.step


import com.monitor.bit.domain.Ticker
import com.monitor.bit.writer.TickerItemWriter
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.Step
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.infrastructure.item.data.RepositoryItemReader

@Configuration
class TickerStepConfig {

    @Bean
    fun tickerStep(
        jobRepository: JobRepository,
        transactionManager: PlatformTransactionManager,
        tickerItemReader: RepositoryItemReader<String>,
        tickerItemWriter: TickerItemWriter
    ): Step =
        StepBuilder("tickerStep", jobRepository)
            .chunk<String, String>(100)
            .reader(tickerItemReader)
            .writer(tickerItemWriter)
            .transactionManager(transactionManager)
            .build()
}
