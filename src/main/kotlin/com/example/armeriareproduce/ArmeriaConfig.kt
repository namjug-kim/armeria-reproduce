package com.example.armeriareproduce

import com.linecorp.armeria.common.reactor3.RequestContextHooks
import com.linecorp.armeria.server.ServerBuilder
import com.linecorp.armeria.server.docs.DocService
import com.linecorp.armeria.server.logging.LoggingService
import com.linecorp.armeria.spring.ArmeriaServerConfigurator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ArmeriaConfig {
    @Bean
    fun armeriaServerConfigurator(annotatedService: AnnotatedService): ArmeriaServerConfigurator {
        RequestContextHooks.enable()

        return ArmeriaServerConfigurator { builder: ServerBuilder ->
            builder.serviceUnder("/docs", DocService())
                .decorator(LoggingService.newDecorator())
                .annotatedService(annotatedService)
        }
    }
}
