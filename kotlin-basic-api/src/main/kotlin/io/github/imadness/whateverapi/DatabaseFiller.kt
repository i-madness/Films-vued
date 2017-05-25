package io.github.imadness.whateverapi

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigInteger
import java.util.concurrent.Executors
import java.util.concurrent.ThreadLocalRandom
import javax.annotation.PostConstruct

/**
 * Сервис для наполнения БД данными
 */
@Service
class DatabaseFiller(val repository: CustomerRepository) {
    private val log = LoggerFactory.getLogger(DatabaseFiller::class.java)
    private val executor = Executors.newSingleThreadScheduledExecutor()
    private val TASK_SHUTDOWN_TIMEOUT: Long = 3

    /**
     * Запускает задание для заполнения
     */
    @PostConstruct
    private fun init() {
        //executor.scheduleAtFixedRate(FillerTask(repository), 0, 6, TimeUnit.SECONDS)
        //executor.awaitTermination(TASK_SHUTDOWN_TIMEOUT, TimeUnit.MINUTES)
        executor.submit(FillerTask(repository))
    }

    /**
     * Задание для наполнения БД рандомно сгенерированными данными
     */
    private class FillerTask(val repository: CustomerRepository) : Runnable {
        val threadRandom = ThreadLocalRandom.current()

        fun randomizeStr(): String {
            return BigInteger(130, threadRandom).toString(32)
        }

        override fun run() {
            for (times in 1..10) {
                val customer = Customer(randomizeStr(), randomizeStr())
                repository.save(customer)
            }
        }

    }
}
