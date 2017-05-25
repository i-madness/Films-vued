package io.github.imadness.whateverapi.logic

import io.github.imadness.whateverapi.domain.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long> {

	fun findByLastName(lastName: String): Iterable<Customer>

}
