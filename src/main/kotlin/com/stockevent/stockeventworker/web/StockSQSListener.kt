package com.stockevent.stockeventworker.web

import com.stockevent.stockeventworker.domain.StockService
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Component

@Component
class StockSQSListener(
    private val stockService: StockService
) {
    @SqsListener(value = ["stock-event-sqs.fifo"], deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    fun readMessage (message: StockMessage) {
        println("message: $message")
        if(message.type == "DECREASE") {
            stockService.decreaseStock(message)
        }
    }
}