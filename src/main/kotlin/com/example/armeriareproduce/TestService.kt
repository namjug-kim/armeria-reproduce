package com.example.armeriareproduce

import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class TestService {
    private val mutex = Mutex()

    suspend fun runWithMutex(): String {
        return mutex.withLock {
            return@withLock Mono.just("test")
                .awaitSingle()
        }
    }
}
