package com.harmellaw

import arrow.core.NonEmptySet

class PoliceInvestigation(val pncId: PNCId, val suspects: NonEmptySet<Suspect>) {

    operator fun plus(suspect: Suspect) = PoliceInvestigation(pncId, suspects + suspect)
}
