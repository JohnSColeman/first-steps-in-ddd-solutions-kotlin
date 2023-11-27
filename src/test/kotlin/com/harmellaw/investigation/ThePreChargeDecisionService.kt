package com.harmellaw.investigation

import arrow.core.nonEmptySetOf
import com.harmellaw.PNCId
import kotlin.test.Test
import kotlin.test.assertEquals

internal class ThePreChargeDecisionService {

    @Test
    fun `should create a pre charge decision case when receiving a pcd request`() {
        val pncId = PNCId("AN-ID")
        val suspect = Suspect(CriminalOffence.CuttingAwayBuoysEtc)
        val policeInvestigationDetails = PoliceInvestigationDetails(pncId, nonEmptySetOf(suspect))
        val pcdCase: PreChargeDecisionCase = receiveRequestForPreChargeDecision(policeInvestigationDetails)
        assertEquals(pncId, pcdCase.pncId)
        assertEquals(policeInvestigationDetails.suspects, pcdCase.offenceAdvice.keys)
    }
}
