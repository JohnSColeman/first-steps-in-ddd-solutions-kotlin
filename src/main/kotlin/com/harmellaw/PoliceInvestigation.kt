package com.harmellaw

import arrow.core.NonEmptySet

class PoliceInvestigation(val pncId: PNCId, val suspects: NonEmptySet<Suspect>) {

    fun addSuspect(suspect: Suspect) = PoliceInvestigation(this.pncId, suspects + suspect)
}
