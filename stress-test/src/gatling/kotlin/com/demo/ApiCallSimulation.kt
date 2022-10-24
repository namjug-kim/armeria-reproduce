package com.demo

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http

class ApiCallSimulation : Simulation() {
    private val reproducScenario = scenario("reproduce IllegalArgument")
        .exec(
            http("mutex.withLock()")
                .get("/test")
        )

    private val httpProtocol = http.baseUrl("http://localhost:8080")

    init {
        setUp(reproducScenario.injectOpen(atOnceUsers(2))).protocols(httpProtocol)
    }
}
