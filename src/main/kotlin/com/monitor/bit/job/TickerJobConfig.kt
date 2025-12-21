package com.monitor.bit.job


import com.monitor.bit.step.TickerStepConfig
import org.springframework.batch.core.job.Job
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.Step
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TickerJobConfig {

    @Bean
    fun tickerJob(
        jobRepository: JobRepository,
        tickerStep: Step
    ): Job =
        JobBuilder("tickerJob", jobRepository)
            .start(tickerStep)
            .build()
}