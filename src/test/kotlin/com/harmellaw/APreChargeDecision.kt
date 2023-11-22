package com.harmellaw

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class APreChargeDecision {
    @BeforeEach
    fun setup() {
    }

    @Disabled("So the CI build stays green.  Remove this to get coding.")
    @Test
    fun shouldRecordAlternativeOffenceAdviceAgainstSuspects() {
        Assertions.fail<Any>()
    }
}
