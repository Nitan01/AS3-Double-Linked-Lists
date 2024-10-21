package application;

import static org.junit.Assert.*; 
import java.util.Comparator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** A group of tests that test the SortedDoubleLinkedList class with Integer values
 * @author nitan
 */
public class SortedDoubleLinkedListStudentTest {

    SortedDoubleLinkedList<Integer> listI;
    
    IntegerComparator comparatorI;
    
    int zero = 0;
    int one = 1;
    int two = 2;
    int three = 3;
    int four = 4;
    int five = 5;
    int six = 6;
    int seven = 7;
    int eight = 8;
    int nine = 9;
    int ten = 10;
    
    /** Sets up the comparator and the list
     * 
     * @throws Exception Any exception that SortedDoubleLinkedList may throw
     */
    @Before
    public void setUp() throws Exception {
        comparatorI = new IntegerComparator();
        listI = new SortedDoubleLinkedList<>(comparatorI);
    }

    /** Tears down the comparator and list
     * 
     * @throws Exception Any exception that SortedDoubleLinkedList may throw
     */
    @After
    public void tearDown() throws Exception {
        comparatorI = null;
        listI = null;
    }

    /** Tests the add method and makes sure that sorting is being done correctly */
    @Test
    public void addTest() {
        listI.add(ten);
        listI.add(two);
        listI.add(five);
        listI.add(one);
        listI.add(four);
        assertTrue("[1, 2, 4, 5, 10]".equals(listI.toArrayList().toString()));
    }
    
    /** Tests that the addToFront method actually throws an exception, as it should */
    @Test
    public void addToFrontTest() {
        try {
            listI.addToFront(one);
            assertTrue("UnsupportedOperationException was not thrown as it should have", false);
        } catch (UnsupportedOperationException uoe) {
            assertTrue("UnsupportedOperationException was thrown as expected", true);
        } catch (Exception e) {
            assertTrue("UnsupportedOperationException was not thrown as it should have", false);
        }
    }
    
    /** Tests that the addToEnd method actually throws an exception, as it should */
    @Test
    public void addToEndTest() {
        try {
            listI.addToEnd(one);
            assertTrue("UnsupportedOperationException was not thrown as it should have", false);
        } catch (UnsupportedOperationException uoe) {
            assertTrue("UnsupportedOperationException was thrown as expected", true);
        } catch (Exception e) {
            assertTrue("UnsupportedOperationException was not thrown as it should have", false);
        }
    }
    
    /** Tests to make sure that the remove method is working as it should */
    @Test
    public void removeTest() {
        listI.add(ten);
        listI.add(two);
        listI.add(five);
        listI.add(one);
        listI.add(four);
        listI.remove(five, comparatorI);
        assertTrue("[1, 2, 4, 10]".equals(listI.toArrayList().toString()));
    }
    
    /** Comparator that compares integers
     */
    private class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer arg0, Integer arg1) {
            return arg0.compareTo(arg1);
        }
    }
}
