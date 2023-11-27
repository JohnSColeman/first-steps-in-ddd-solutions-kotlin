package com.harmellaw.investigation

fun receiveRequestForPreChargeDecision(policeInvestigationDetails: PoliceInvestigationDetails) =
    PreChargeDecisionCase(policeInvestigationDetails.pncId, policeInvestigationDetails.suspects)
