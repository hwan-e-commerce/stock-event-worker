package com.stockevent.stockeventworker.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.lang.IllegalArgumentException
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "stocks")
class Stock (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val itemToken: String,

    @Column(nullable = false)
    var remain: Int,

    @CreatedDate
    var createdAt: LocalDateTime,

    @LastModifiedDate
    var updatedAt : LocalDateTime
) {
    fun decreaseStock(cnt: Int) {
        decreaseValidCheck(cnt);
        remain -= cnt;
    }

    private fun decreaseValidCheck(cnt: Int) {
        if(remain - cnt < 0) {
            throw IllegalArgumentException("수량 초과");
        }
    }
}