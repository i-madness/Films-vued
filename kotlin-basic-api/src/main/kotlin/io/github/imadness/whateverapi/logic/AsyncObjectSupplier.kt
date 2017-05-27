package io.github.imadness.whateverapi.logic

import io.github.imadness.whateverapi.domain.HugeObject
import org.slf4j.LoggerFactory
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import org.springframework.stereotype.Service
import java.util.concurrent.Executors
import java.util.concurrent.Future

@Service
class AsyncObjectSupplier(val restTemplateBuilder: RestTemplateBuilder) {
    private val LOGGER = LoggerFactory.getLogger(AsyncObjectSupplier::class.java)
    private val executor = Executors.newSingleThreadExecutor()
    private val restTemplate = restTemplateBuilder.build()

    @Async
    fun getHugeObjectAsync(): Future<String> {
        var entries = restTemplate.getForObject("http://jsonplaceholder.typicode.com/albums", Array<HugeObject.SubEntry>::class.java)
        return AsyncResult(HugeObject(entries).toString())
    }
}