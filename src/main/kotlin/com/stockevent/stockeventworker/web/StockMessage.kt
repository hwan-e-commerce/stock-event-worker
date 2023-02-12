package com.stockevent.stockeventworker.web

data class StockMessage(
    val itemToken: String,
    val orderToken: String,
    val orderCnt: Int,
    val eventType: String
) {
    fun toStockDto(): StockDto {
        return StockDto(
            itemToken,
            orderToken,
            orderCnt
        )
    }
}

data class StockDto(
    val itemToken: String,
    val orderToken: String,
    val orderCnt: Int
)