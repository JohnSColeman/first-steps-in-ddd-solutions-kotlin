package com.harmellaw

/*
 * List from https://www.cps.gov.uk/sites/default/files/documents/publications/annex_1a_table_of_offences_scheme_c.pdf
 */
sealed class CriminalOffence(val value: String) {
    data object DangerousDriving : CriminalOffence("Dangerous driving")
    data object EndangeringAnAircraft : CriminalOffence("Endangering an aircraft")
    data object FalseAccounting : CriminalOffence("False accounting")
    data object ImpersonatingCustomsOfficer : CriminalOffence("Impersonating Customs officer")
    data object KeepingADisorderlyHouse : CriminalOffence("Keeping a disorderly house")
    data object CorruptionInPublicOffice : CriminalOffence("Corruption in public office")
    data object CuttingAwayBuoys : CriminalOffence("Cutting away buoys etc")
    data object FalseEvidenceBeforeEuropeanCourt : CriminalOffence("False evidence before European Court")
    data object FiringOnRevenueVessel : CriminalOffence("Firing on Revenue vessel")
    data object FraudulentEvasionOfAgriculturalLevy : CriminalOffence("Fraudulent evasion of agricultural levy")
    data object ObstructingEngineOrCarriageOnRailway : CriminalOffence("Obstructing engine or carriage on railway")
}
