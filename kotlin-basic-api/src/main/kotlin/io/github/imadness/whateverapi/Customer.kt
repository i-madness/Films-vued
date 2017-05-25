package io.github.imadness.whateverapi

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * POJO (или POKO?) для описания тривиальной сущности для БД
 */
@Entity
class Customer {
    lateinit var firstName: String // отложенная инициализация (!)
    lateinit var  lastName: String
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    /**
     * Дефолтный конструктор. Необходим Hibernate (!)
     */
    constructor() { }

    /**
     * Конструктор с полями
     */
    constructor(firstName: String, lastName: String) {
        this.firstName = firstName
        this.lastName = lastName
    }

	override fun toString(): String {
		return "Customer(id=$id, firstName='$firstName', lastName='$lastName')"
	}

    override fun hashCode(): Int {
        return Objects.hash(id, firstName, lastName)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other is Customer) {
            return id == other.id && firstName == other.firstName && lastName == other.lastName
        }
        return false;
    }
}
