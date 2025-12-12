package com.monitor.bit.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class WebClientConfig(
    @Value("\${upbit.api.base-url}")
    private val BASE_URL: String
) {

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .baseUrl(BASE_URL)
            .build()
    }

}