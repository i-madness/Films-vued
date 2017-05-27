package io.github.imadness.whateverapi.logic

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.Future

@RestController
class CustomerController(val repository: CustomerRepository, val asyncObjectSupplier: AsyncObjectSupplier) {

	@GetMapping("/")
	fun findAll() = repository.findAll()

	@GetMapping("/{lastName}")
	fun findByLastName(@PathVariable lastName: String) = repository.findByLastName(lastName)

    @GetMapping("/ho")
    fun fetchVeryHugeObject(): Future<String> = asyncObjectSupplier.getHugeObjectAsync()
}