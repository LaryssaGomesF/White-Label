package com.example.whitelabelpdi.common.failure

sealed class BaseFailure(
    override val message: String,
    open val code: Int): Throwable(message)

class NoNetworkConnectionFailure(
    override val message: String = "",
    override val code: Int = 0
): BaseFailure(message, code)

class RequestFailure(
    override val message: String = "",
    override val code: Int = 0
): BaseFailure(message, code)