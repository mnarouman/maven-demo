package fr.mna;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.mna.m2.AppModule2;
import fr.mna.m2.MaClasseM2;

/**
 * Unit test for simple App.
 */
@Category({T2.class, ALL.class})
public class AppTest2{
	private Logger logger = LoggerFactory.getLogger(AppTest2.class);

	@Test
	public void AppModule2Test1Ok() {
		//given
		AppModule2 appModule2 = new AppModule2(AppModule2.TEST1);
		
		// when
		boolean b = appModule2.isValid();
		
		//then
		assertThat(b).isFalse();
	}
	
	@Test
	public void AppModule2Test2Ok() {
		//given
		AppModule2 appModule2 = new AppModule2(AppModule2.TEST2);
		
		// when
		boolean b = appModule2.isValid();
		
		//then
		assertThat(b).isTrue();
	}
	
	@Test
	public void MaClasseM2Test() {
		//given
		MaClasseM2 classeM2 = new MaClasseM2();
		
		// when
		Long maMethode = classeM2.maMethode(10L);
		
		//then
		assertThat(maMethode).isEqualTo(8L);
	}
}
