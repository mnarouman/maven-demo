package com.business;

import fr.mna.m1.MaClasse;

public class UnClassBusiness implements IUnClassBusiness {
	// FIXME test de bug...
	public Long uneMethode() {
		MaClasse maClasse = new MaClasse();

		Long result = maClasse.maMethode(20L);

		return result;
	}
}
