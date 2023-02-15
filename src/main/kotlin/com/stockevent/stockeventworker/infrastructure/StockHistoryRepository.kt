package com.stockevent.stockeventworker.infrastructure

import com.stockevent.stockeventworker.domain.StockHistory
import org.springframework.data.jpa.repository.JpaRepository

interface StockHistoryRepository: JpaRepository<StockHistory, Long>