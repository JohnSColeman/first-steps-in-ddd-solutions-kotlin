package com.harmellaw.preparation

import arrow.core.NonEmptySet
import com.harmellaw.PNCId

class CriminalCase(var pncId: PNCId, var defendants: NonEmptySet<Defendant>)

