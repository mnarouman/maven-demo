package fr.mna.m2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class AppModule2 {
    public AppModule2(String testName) {
		super();
		this.testName = testName;
	}

	public static final String TEST1 = "test1";
    public static final String TEST2 = "test2";
    private String testName;

    public final boolean isValid() {
    	boolean isValid = false;
        if (this.testName.equals(TEST1)) {
            isValid = false;
        } 
        if (this.testName.equals(TEST2)) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * @param args
     */
//    public static void main(final String[] args) {
//        List<String> l = new ArrayList<String>();
//        l.add("Sub");
//        l.add("Mul");
//        l.add("Div");
//        Iterator<String> itr = l.iterator();
//        while (itr.hasNext()) {
//            System.out.println(itr.next());
//            l.add("Add");
//        }
//    }
}