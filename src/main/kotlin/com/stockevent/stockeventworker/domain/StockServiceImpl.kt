package com.stockevent.stockeventworker.domain

import com.stockevent.stockeventworker.infrastructure.StockRepository
import com.stockevent.stockeventworker.web.StockDto
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import javax.transaction.Transactional

@Service
class StockServiceImpl(
    private val stockRepository: StockRepository
) : StockService {

    @Transactional
    override fun decreaseStock(stockDto: StockDto) {
        val storedStock = stockRepository.findByItemToken(stockDto.itemToken)
            .orElseThrow(::IllegalArgumentException)

        storedStock.decreaseStock(stockDto.orderCnt);
    }
}