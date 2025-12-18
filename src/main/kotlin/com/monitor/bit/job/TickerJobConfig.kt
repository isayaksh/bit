package com.monitor.bit.job


import com.monitor.bit.step.TickerStepConfig
import org.springframework.batch.core.job.Job
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TickerJobConfig(
    private val jobRepository: JobRepository,
    private val tickerStepConfig: TickerStepConfig
) {

    @Bean
    fun tickerJob(): Job =
        JobBuilder("tickerJob", jobRepository)
            .start(tickerStepConfig.tickerStep())
            .build()
}