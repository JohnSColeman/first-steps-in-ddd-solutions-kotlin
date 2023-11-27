package com.harmellaw.preparation

import arrow.core.NonEmptySet
import com.harmellaw.PNCId

class PoliceCaseFile(val pncId: PNCId, val defendants: NonEmptySet<Defendant>) {

    operator fun plus(defendant: Defendant) = PoliceCaseFile(pncId, defendants + defendant)
}
