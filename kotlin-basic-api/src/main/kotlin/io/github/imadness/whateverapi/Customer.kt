package io.github.imadness.whateverapi

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Customer {
    lateinit var firstName: String
    lateinit var  lastName: String
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    constructor() { }
    constructor(firstName: String, lastName: String) {
        this.firstName = firstName
        this.lastName = lastName
    }

	override fun toString(): String {
		return "Customer(id=$id, firstName='$firstName', lastName='$lastName')"
	}
}
