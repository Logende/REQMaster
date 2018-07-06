package org.dhbw.stuttgart.ita16.reqmaster.model;

/**
 * FPKlassifizierungen werden im Rahmen der FP-Analyse verwendet.
 * Jeder ProduktFunktion bzw. jedem -Datum wird vom Anwender eine Klassifizierung zugeordnet.
 */
public enum FPKlassifizierung {

	TRANSAKTION_EI,
	TRANSAKTION_EO,
	TRANSAKTION_EQ,
	DATEN_ILF,
	DATEN_ELF
}
