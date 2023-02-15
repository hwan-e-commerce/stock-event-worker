package com.stockevent.stockeventworker.web

data class StockMessage(
    val orderInfos: List<OrderItemInfo>,
    val type: String
) {
    constructor() : this(listOf(), "")
}

data class OrderItemInfo(
    val orderToken: String,
    val itemToken: String,
    val orderCnt: Int,
    val orderedAt: String
) {
    constructor() : this("", "", 0, "")
}