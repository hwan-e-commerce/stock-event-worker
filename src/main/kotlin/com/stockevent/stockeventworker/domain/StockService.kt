package com.stockevent.stockeventworker.domain

import com.stockevent.stockeventworker.web.StockDto
import com.stockevent.stockeventworker.web.StockMessage

interface StockService {
    fun decreaseStock(stockDto: StockDto)
}