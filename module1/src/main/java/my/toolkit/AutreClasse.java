package my.toolkit;

import org.apache.commons.lang3.StringUtils;

import fr.mna.m1.MaClasse;

public class AutreClasse {

    public AutreClasse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long uneMethode(){
        MaClasse maClasse = new MaClasse();

        Long result = maClasse.maMethode(20L);
        
        return result;
    }
    
    @Deprecated
	public boolean autreMethod(String ligne) {
		return !StringUtils.isBlank(ligne) && !ligne.startsWith("T");
	}
    
    @Deprecated
   	public boolean autreMethod1(String ligne) {
   		return !StringUtils.isBlank(ligne) && !ligne.startsWith("T");
   	}
}
