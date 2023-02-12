package com.stockevent.stockeventworker.infrastructure

import com.stockevent.stockeventworker.domain.Stock
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface StockRepository: JpaRepository<Stock, Long> {
    fun findByItemToken(itemToken: String): Optional<Stock>
}