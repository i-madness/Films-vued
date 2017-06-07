package io.github.imadness.whateverapi

import io.github.imadness.whateverapi.logic.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class Application {

    private val log = LoggerFactory.getLogger(Application::class.java)

    @Bean
    open fun init(repository: CustomerRepository) = CommandLineRunner {

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}