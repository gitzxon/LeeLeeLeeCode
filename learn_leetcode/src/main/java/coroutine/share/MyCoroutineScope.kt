package coroutine.share

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors

val myCoroutineDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
val myCoroutineScope = CoroutineScope(myCoroutineDispatcher)