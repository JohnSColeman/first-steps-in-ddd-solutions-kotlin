package com.harmellaw.preparation

import arrow.core.nonEmptySetOf
import com.harmellaw.PNCId
import com.harmellaw.investigation.CriminalOffence
import com.harmellaw.investigation.PoliceInvestigationDetails
import com.harmellaw.investigation.Suspect
import kotlin.test.Test
import kotlin.test.assertEquals

internal class TheTrialPreparationService {

    @Test
    fun `should create a criminal case when a police case file is accepted`() {
        val pncId = PNCId("AN-ID")
        val suspect = Suspect(CriminalOffence.CuttingAwayBuoysEtc)
        val policeInvestigationDetails = PoliceInvestigationDetails(pncId, nonEmptySetOf(suspect))

        val defendant = Defendant()
        val policeCaseFile = PoliceCaseFile(pncId, nonEmptySetOf(defendant))
        val criminalCase: CriminalCase = acceptCaseFile(policeCaseFile)
        assertEquals(pncId, criminalCase.pncId)
        assertEquals(policeCaseFile.defendants, criminalCase.defendants)
    }
}