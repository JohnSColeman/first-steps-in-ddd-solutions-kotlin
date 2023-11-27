package com.harmellaw.investigation

import arrow.core.nonEmptySetOf
import com.harmellaw.PNCId
import kotlin.test.Test
import kotlin.test.assertEquals

internal class APreChargeDecisionCase {

    @Test
    fun `should record alternative offence advice against suspects`() {
        val pncId = PNCId("ANOTHER_PNC_ID")
        val suspect = Suspect(CriminalOffence.CuttingAwayBuoysEtc)
        val aPreChargeDecisionCase = PreChargeDecisionCase(pncId, nonEmptySetOf(suspect))
        val offenceAdvice = OffenceAdvice()
        val actual = aPreChargeDecisionCase.recordAlternativeOffenceAdvice(suspect to offenceAdvice)
        assertEquals(offenceAdvice, actual.offenceAdvice[suspect])
    }
}
