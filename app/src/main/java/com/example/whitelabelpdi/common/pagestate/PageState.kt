package com.example.whitelabelpdi.common.pagestate

sealed class PageState<out S : Any, out E : Throwable>

class SuccessState<out S : Any>(val value: S) : PageState<S, Nothing>()

class ErrorState<out T : Throwable>(val value: T) : PageState<Nothing, T>()

object LoadingState : PageState<Nothing, Nothing>()

object NoneState : PageState<Nothing, Nothing>()
