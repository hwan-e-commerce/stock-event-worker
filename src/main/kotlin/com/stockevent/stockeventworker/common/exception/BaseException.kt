package com.stockevent.stockeventworker.common.exception

sealed class BaseException(
    message: String ?
) : RuntimeException(message)

data class EntityNotFoundException(
    override val message: String
) : BaseException(message)
