package com.harmellaw.investigation

import arrow.core.NonEmptySet
import com.harmellaw.PNCId

class PoliceInvestigationDetails(val pncId: PNCId, val suspects: NonEmptySet<Suspect>) {

    operator fun plus(suspect: Suspect) = PoliceInvestigationDetails(pncId, suspects + suspect)
}
