package org.dhbw.stuttgart.ita16.reqmaster.model;


public enum FPFunktionsTyp {

	DATEN{
		public FPKlassifizierung getDefaultKlassifizierung(){
			return FPKlassifizierung.DATEN_ELF;
		}
	},
	TRANSAKTION{
		public FPKlassifizierung getDefaultKlassifizierung(){
			return FPKlassifizierung.TRANSAKTION_EO;
		}
	};

	public abstract FPKlassifizierung getDefaultKlassifizierung();
}
