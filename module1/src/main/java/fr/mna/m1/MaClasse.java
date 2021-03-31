package fr.mna.m1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

public class MaClasse {
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MaClasse.class);

	/**
	 * Ceci est un commentaire
	 *
	 */
	public Long maMethode(Long ok) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.info("Coucou");
		}

		long returnValue = 0;
		try {
			returnValue = ok ^ 2;
			if (returnValue > 100) {
				returnValue -= 100;
			} else {
				returnValue += 10;
			}
		} catch (Exception e) {
			// TODO creer une exception
		}
		return returnValue;
	}

	@Deprecated
	public boolean autreMethod(String ligne) {
		return !StringUtils.isBlank(ligne) && !ligne.startsWith("T");
	}
	
	public int loadFile() {
		int read = -1;
		try {
			String file = "michel.txt";
			FileInputStream inputStream = new FileInputStream(file);
			read = inputStream.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return read;
	}
}
