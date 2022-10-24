package com.example.armeriareproduce

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class AnnotatedService(private val testService: TestService) {
    @GetMapping("/test")
    suspend fun test(): String {
        return testService.runWithMutex()
    }
}
