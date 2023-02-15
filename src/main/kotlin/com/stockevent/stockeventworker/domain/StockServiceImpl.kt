package com.stockevent.stockeventworker.domain

import com.stockevent.stockeventworker.infrastructure.StockHistoryRepository
import com.stockevent.stockeventworker.web.StockMessage
import org.springframework.stereotype.Service
import javax.transaction.Transactional
import kotlin.streams.toList

@Service
class StockServiceImpl(
    private val stockRepository: StockHistoryRepository
) : StockService {

    @Transactional
    override fun decreaseStock(stockMessage: StockMessage) {
        val orderItems = stockMessage.orderInfos

        val stockHistories = orderItems.stream()
            .map { orderItemInfo -> StockHistory.of(orderItemInfo, stockMessage.type) }
            .toList()

        stockRepository.saveAll(stockHistories)
    }
}