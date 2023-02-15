package com.stockevent.stockeventworker.domain

import com.stockevent.stockeventworker.web.StockMessage

interface StockService {
    fun decreaseStock(stockMessage: StockMessage)
}