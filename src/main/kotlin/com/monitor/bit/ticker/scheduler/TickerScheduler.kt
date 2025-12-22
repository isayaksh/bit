package com.monitor.bit.ticker.scheduler

import org.springframework.batch.core.job.Job
import org.springframework.batch.core.job.parameters.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class TickerScheduler(
    private val jobLauncher: JobLauncher,
    private val tickerJob: Job
) {
    @Scheduled(cron = "0 * * * * *") // 매 분 0초 실행
    fun runJob() {
        val params = JobParametersBuilder()
            .addLong("timestamp", System.currentTimeMillis()) // 중복 실행 방지
            .toJobParameters()

        jobLauncher.run(tickerJob, params)
    }
}