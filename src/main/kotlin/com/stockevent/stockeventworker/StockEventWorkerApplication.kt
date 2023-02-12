package com.stockevent.stockeventworker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StockEventWorkerApplication

fun main(args: Array<String>) {
    runApplication<StockEventWorkerApplication>(*args)
}
