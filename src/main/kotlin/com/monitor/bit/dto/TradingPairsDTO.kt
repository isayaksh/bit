package com.monitor.bit.dto

import com.monitor.bit.domain.TradingPair

data class TradingPairsDTO(
    val market: String,
    val korean_name: String,
    val english_name: String
) {
    fun toEntity(): TradingPair {
        return TradingPair(
            market = market,
            koreanName = korean_name,
            englishName = english_name
        )
    }
}
