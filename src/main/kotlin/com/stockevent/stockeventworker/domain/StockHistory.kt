package com.stockevent.stockeventworker.domain

import com.stockevent.stockeventworker.web.OrderItemInfo
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.lang.IllegalArgumentException
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "stock_history")
class StockHistory (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "order_token", unique = true, nullable = false)
    val orderToken: String,

    @Column(name = "item_token", nullable = false)
    val itemToken: String,

    @Column(name = "order_cnt", nullable = false)
    val orderCnt: Int,

    @Column(name = "type")
    val type: String,

    @CreatedDate
    @Column(name = "ordered_at", nullable = false)
    var orderedAt: String,
) {
    override fun toString(): String {
        return "StockHistory: {" +
                    "id=$id," +
                    "orderToken='$orderToken'," +
                    "itemToken='$itemToken', " +
                    "orderCnt='$orderCnt', " +
                    "orderedAt=$orderedAt" +
                    "type=$type" +
                "}"
    }

    companion object{
        fun of(orderItemInfo: OrderItemInfo, type: String): StockHistory {
            return StockHistory(
                orderToken = orderItemInfo.orderToken,
                itemToken = orderItemInfo.itemToken,
                orderCnt = orderItemInfo.orderCnt,
                orderedAt = orderItemInfo.orderedAt,
                type = type
            )
        }
    }
}