package fr.mna;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import fr.mna.m1.MaClasse;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
@Category({T1.class, ALL.class})
public class AppTestIT extends TestCase{

//    /**
//     * test 01.
//     */
//    @Test
//    public final void test2() {
//        // given
//        MaClasse maClasse = new MaClasse();
//
//        // when
//        Long result = maClasse.maMethode(20L);
//
//        // then
//        assertThat(result).isLessThanOrEqualTo(100);
//    }

     @Test
     public void test3() {
     //given
     MaClasse maClasse = new MaClasse();
    
     //when
     Long result = maClasse.maMethode(200L);
    
     //then
     assertThat(result).isGreaterThanOrEqualTo(100);
     }

}
