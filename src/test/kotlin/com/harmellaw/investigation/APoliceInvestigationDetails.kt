package com.harmellaw.investigation

import arrow.core.nonEmptySetOf
import com.harmellaw.PNCId
import kotlin.test.Test
import kotlin.test.assertContains

internal class APoliceInvestigationDetails {
    // null check tests not required - the Kotlin domain model will not permit null values

    @Test
    fun `should add suspect to police investigation details`() {
        val pncId = PNCId("ANOTHER_PNC_ID")
        val suspect1 = Suspect(CriminalOffence.CuttingAwayBuoysEtc)
        val investigationDetails1 = PoliceInvestigationDetails(pncId, nonEmptySetOf(suspect1))
        val suspect2 = Suspect(CriminalOffence.CuttingAwayBuoysEtc)
        val investigationDetails2 = investigationDetails1 + suspect2
        assertContains(investigationDetails2.suspects, suspect1)
        assertContains(investigationDetails2.suspects, suspect2)
    }
}
