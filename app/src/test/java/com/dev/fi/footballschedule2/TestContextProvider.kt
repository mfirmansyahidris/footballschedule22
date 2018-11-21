package com.dev.fi.footballschedule2

import com.dev.fi.footballschedule2.utils.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.coroutines.CoroutineContext

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class TestContextProvider : CoroutineContextProvider() {
    @ExperimentalCoroutinesApi
    override val main: CoroutineContext = Dispatchers.Unconfined
}