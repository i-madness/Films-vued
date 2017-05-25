package io.github.imadness.whateverapi.logic

import io.github.imadness.whateverapi.domain.Customer
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigInteger
import java.util.concurrent.Executors
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit
import javax.annotation.PostConstruct

/**
 * Сервис для наполнения БД данными
 */
@Service
class DatabaseFiller(val repository: CustomerRepository) {
    private val LOGGER = LoggerFactory.getLogger(DatabaseFiller::class.java)
    private val TASK_SHUTDOWN_TIMEOUT: Long = 9
    private val executor = Executors.newSingleThreadScheduledExecutor()

    /**
     * Запускает задание для заполнения
     */
    @PostConstruct
    private fun init() {
        executor.scheduleAtFixedRate(FillerTask(repository), 0, 3, TimeUnit.SECONDS)
    }

    /**
     * Задание для наполнения БД рандомно сгенерированными данными
     */
    private class FillerTask(val repository: CustomerRepository) : Runnable {
        val LOGGER = LoggerFactory.getLogger(FillerTask::class.java)
        val threadRandom = ThreadLocalRandom.current()

        fun randomizeStr(): String {
            return BigInteger(130, threadRandom).toString(32)
        }

        override fun run() {
            val customer = Customer(randomizeStr(), randomizeStr())
            repository.save(customer)
            LOGGER.debug("Добавлено в БД: $customer")
        }

    }
}
