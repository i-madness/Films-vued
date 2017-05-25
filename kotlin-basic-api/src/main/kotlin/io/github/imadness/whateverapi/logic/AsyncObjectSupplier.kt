package io.github.imadness.whateverapi.logic

import io.github.imadness.whateverapi.domain.HugeObject
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.net.URI
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

@Service
class AsyncObjectSupplier {
    private val LOGGER = LoggerFactory.getLogger(AsyncObjectSupplier::class.java)
    private val executor = Executors.newSingleThreadExecutor()

    fun getHugeObjectAsync(): CompletableFuture<HugeObject> {
        return CompletableFuture.supplyAsync {
            return@supplyAsync HugeObject(URI("http://jsonplaceholder.typicode.com/albums").toURL().content.toString())
        }
    }
}