package com.harmellaw.investigation

import arrow.core.NonEmptySet
import com.harmellaw.PNCId
import com.harmellaw.SuspectOffenceAdvice

class PreChargeDecisionCase private constructor(val pncId: PNCId, val offenceAdvice: Map<Suspect, OffenceAdvice?>) {

    fun recordAlternativeOffenceAdvice(advice: SuspectOffenceAdvice) =
        PreChargeDecisionCase(pncId, offenceAdvice + advice)

    companion object {
        operator fun invoke(pncId: PNCId, suspects: NonEmptySet<Suspect>) =
            PreChargeDecisionCase(pncId, suspects.associateWith { null })
    }
}
