package io.github.imadness.whateverapi.domain

import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Что бы это ни было...
 */
class HugeObject (entries: Array<SubEntry>) {
    class SubEntry (userId: Int, id: Int, title: String) {

    }

    override fun toString(): String {
        return ObjectMapper().writeValueAsString(this)
    }
}