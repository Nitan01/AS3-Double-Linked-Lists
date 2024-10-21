package application;

import static org.junit.Assert.*; 

import java.util.Comparator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** A group of unit tests that test the BasicDoubleLinkedList class
 * 
 * @author nitan
 *
 */
public class BasicDoubleLinkedListStudentTest {
    BasicDoubleLinkedList<Double> listD;
    BasicDoubleLinkedList<String> listS;

    DoubleComparator comparatorD;
    StringComparator comparatorS;

    Double onePointFive = 1.5;
    Double twoPointFive = 2.5;
    Double threePointFive = 3.5;
    Double fourPointFive = 4.5;
    Double fivePointFive = 5.5;

    String apple = "apple";
    String banana = "banana";
    String cherry = "cherry";
    String date = "date";
    String elderberry = "elderberry";

    /** Sets up the lists and comparators
     * 
     * @throws Exception Any exception that BasicDoubleLinkedList may throw
     */
    @Before
    public void setUp() throws Exception {
        listD = new BasicDoubleLinkedList<>();
        listS = new BasicDoubleLinkedList<>();

        comparatorD = new DoubleComparator();
        comparatorS = new StringComparator();
    }

    /** Tears down lists and comparators
     * 
     * @throws Exception Any exception that BasicDoubleLinkedList may throw
     */
    @After
    public void tearDown() throws Exception {
        listD = null;
        listS = null;
        comparatorD = null;
        comparatorS = null;
    }

    /** Tests adding an item to the end */
    @Test
    public void addToEndTest() {
        listD.addToEnd(onePointFive);
        assertEquals(onePointFive, listD.getLast());
        listD.addToEnd(twoPointFive);
        assertEquals(twoPointFive, listD.getLast());
        listD.addToFront(threePointFive);
        assertEquals(twoPointFive, listD.getLast());
        listD.addToEnd(fourPointFive);
        listD.addToEnd(fivePointFive);
        assertEquals(fivePointFive, listD.getLast());

        listS.addToEnd(apple);
        listS.addToEnd(banana);
        listS.addToFront(cherry);
        listS.addToFront(date);
        assertEquals(banana, listS.getLast());
        listS.addToEnd(elderberry);
        assertEquals(elderberry, listS.getLast());
    }

    /** Tests adding an item to the front */
    @Test
    public void addToFrontTest() {
        listD.addToEnd(fivePointFive);
        assertEquals(fivePointFive, listD.getFirst());
        listD.addToFront(twoPointFive);
        assertEquals(twoPointFive, listD.getFirst());
        listD.addToEnd(fourPointFive);
        assertEquals(twoPointFive, listD.getFirst());

        listS.addToFront(elderberry);
        assertEquals(elderberry, listS.getFirst());
        listS.addToEnd(banana);
        listS.addToEnd(apple);
        assertEquals(elderberry, listS.getFirst());
    }

    /** Tests getting the first item from the list */
    @Test
    public void getFirstTest() {
        listD.addToFront(twoPointFive);
        assertEquals(twoPointFive, listD.getFirst());
        listD.addToEnd(threePointFive);
        assertEquals(twoPointFive, listD.getFirst());

        listS.addToFront(banana);
        listS.addToFront(cherry);
        assertEquals(cherry, listS.getFirst());
        listS.addToEnd(date);
        assertEquals(cherry, listS.getFirst());
    }

    /** Tests getting the last item in the list */
    @Test
    public void getLastTest() {
        listD.addToFront(fivePointFive);
        assertEquals(fivePointFive, listD.getLast());
        listD.addToFront(twoPointFive);
        assertEquals(fivePointFive, listD.getLast());

        listS.addToFront(apple);
        assertEquals(apple, listS.getLast());
        listS.addToFront(cherry);
        assertEquals(apple, listS.getLast());
    }

    /** Tests getting the size of the list */
    @Test
    public void getSizeTest() {
        listD.addToFront(twoPointFive);
        listD.addToEnd(threePointFive);
        assertEquals(2, listD.getSize());
        listD.addToEnd(fourPointFive);
        assertEquals(3, listD.getSize());

        listS.addToFront(cherry);
        listS.addToEnd(banana);
        assertEquals(2, listS.getSize());
        listS.addToEnd(apple);
        assertEquals(3, listS.getSize());
    }

    /** Tests retrieving the first element in the list */
    @Test
    public void retrieveFirstElementTest() {
        listD.addToEnd(onePointFive);
        listD.addToEnd(twoPointFive);
        listD.addToEnd(threePointFive);
        assertEquals(onePointFive, listD.retrieveFirstElement());
        assertEquals(twoPointFive, listD.retrieveFirstElement());

        listS.addToEnd(apple);
        listS.addToEnd(banana);
        assertEquals(apple, listS.retrieveFirstElement());
        assertEquals(banana, listS.retrieveFirstElement());
    }

    /** Tests retrieving the last element in the list */
    @Test
    public void retrieveLastElementTest() {
        listD.addToEnd(onePointFive);
        listD.addToEnd(twoPointFive);
        assertEquals(twoPointFive, listD.retrieveLastElement());
        assertEquals(onePointFive, listD.retrieveLastElement());

        listS.addToEnd(apple);
        listS.addToEnd(banana);
        assertEquals(banana, listS.retrieveLastElement());
        assertEquals(apple, listS.retrieveLastElement());
    }

    /** Tests removing elements from the list */
    @Test
    public void removeTest() {
        listD.addToEnd(threePointFive);
        listD.addToFront(twoPointFive);
        listD.remove(twoPointFive, comparatorD);
        assertTrue("[3.5]".equals(listD.toArrayList().toString()));

        listS.addToFront(cherry);
        listS.addToFront(date);
        listS.remove(date, comparatorS);
        assertTrue("[cherry]".equals(listS.toArrayList().toString()));
    }

    /** Tests converting the list to an ArrayList */
    @Test
    public void toArrayListTest() {
        listD.addToFront(fivePointFive);
        listD.addToFront(twoPointFive);
        assertTrue("[2.5, 5.5]".equals(listD.toArrayList().toString()));

        listS.addToFront(apple);
        listS.addToEnd(banana);
        assertTrue("[apple, banana]".equals(listS.toArrayList().toString()));
    }

    /** String Comparator that compares strings
     * 
     */
    private class StringComparator implements Comparator<String> {
        @Override
        public int compare(String arg0, String arg1) {
            return arg0.compareTo(arg1);
        }
    }

    /** Double Comparator that compares doubles
     * 
     */
    private class DoubleComparator implements Comparator<Double> {
        @Override
        public int compare(Double arg0, Double arg1) {
            return arg0.compareTo(arg1);
        }
    }
}
