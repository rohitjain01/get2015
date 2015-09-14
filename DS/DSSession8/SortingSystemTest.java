import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SortingSystemTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	/**
	 * Bubble Sort Test cases
	 * bubbletest1(), bubbletest2(), bubbletest3(), bubbletest4()
	 */

	@Test
	public void bubbletest1() {
		int[] output = BubbleSort.bubblesort( new int[]{56, 65, 1, 76, 45, 76} );
		int[] expected = new int[]{1, 45, 56, 65, 76, 76};
		assertArrayEquals( expected, output );
	}
	
	@Test
	public void bubbletest2() {
		int[] output = BubbleSort.bubblesort( new int[]{} );
		int[] expected = new int[]{};
		assertArrayEquals( expected, output );
	}
	
	@Test
	public void bubbletest3() {
		int[] output = BubbleSort.bubblesort( new int[]{56} );
		int[] expected = new int[]{56};
		assertArrayEquals( expected, output );
	}
	
	@Test
	public void bubbletest4() {
		int[] output = BubbleSort.bubblesort( new int[]{-1, -2, -6 , -5} );
		int[] expected = new int[]{-6, -5, -2, -1};
		assertArrayEquals( expected, output );
	}
	
	
	/**
	 * Quick Sort Test cases
	 * quicktest1(), quicktest2(), quicktest3(), quicktest4()
	 */
	@Test
	public void quicktest1() {
		int[] output = QuickSort.quickSort( new int[]{56, 65, 1, 76, 45, 76}, 0, 5 );
		int[] expected = new int[]{1, 45, 56, 65, 76, 76};
		assertArrayEquals( expected, output );
	}
	
	@Test
	public void quicktest2() {
		int[] output = QuickSort.quickSort( new int[]{}, -1, -1 );
		int[] expected = new int[]{};
		assertArrayEquals( expected, output );
	}
	
	@Test
	public void quicktest3() {
		int[] output = QuickSort.quickSort( new int[]{56}, 0, 0 );
		int[] expected = new int[]{56};
		assertArrayEquals( expected, output );
	}
	
	@Test
	public void quicktest4() {
		int[] output = QuickSort.quickSort( new int[]{-1, -2, -6 , -5}, 0, 3 );
		int[] expected = new int[]{-6, -5, -2, -1};
		assertArrayEquals( expected, output );
	}
	
	/**
	 * Counting Sort Test cases
	 * countingtest1(), coutingtest2(), countingtest3(), countingtest4()
	 */
	@Test
	public void countingtest1() {
		int[] output = CountingSort.countSort( new int[]{56, 65, 1, 76, 45, 76}, 76 );
		int[] expected = new int[]{1, 45, 56, 65, 76, 76};
		assertArrayEquals( expected, output );
	}
	
	@Test
	public void countingtest2() {
		int[] output = CountingSort.countSort( new int[]{}, -1 );
		int[] expected = new int[]{};
		assertArrayEquals( expected, output );
	}
	
	@Test
	public void countingtest3() {
		int[] output = CountingSort.countSort( new int[]{56}, 56 );
		int[] expected = new int[]{56};
		assertArrayEquals( expected, output );
	}
	
	@Test
	public void countingtest4() {						// counting sort doesn't work for if array contains negitive elements
		int[] output = CountingSort.countSort( new int[]{-1, -2, -6 , -5}, -1 );
		int[] expected = new int[]{-1, -2, -6, -5};
		assertArrayEquals( expected, output );
	}
	
	/**
	 * Radix Sort Test cases
	 * radixtest1(), radixtest2(), radixtest3(), radixtest4()
	 */
	@Test
	public void radixtest1() {
		int[] output = RadixSort.radixSort( new int[]{56, 65, 1, 76, 45, 76}, 76 );
		int[] expected = new int[]{1, 45, 56, 65, 76, 76};
		assertArrayEquals( expected, output );
	}
	
	@Test
	public void radixtest2() {
		int[] output = RadixSort.radixSort( new int[]{}, 0 );
		int[] expected = new int[]{};
		assertArrayEquals( expected, output );
	}
	
	@Test
	public void radixtest3() {
		int[] output = RadixSort.radixSort( new int[]{56}, 56 );
		int[] expected = new int[]{56};
		assertArrayEquals( expected, output );
	}
	
	@Test
	public void radixtest4() {				// radix sorting is also not when array contains negitive elements 
		int[] output = RadixSort.radixSort( new int[]{-1, -2, -6 , -5}, -1 );
		int[] expected = new int[]{-1, -2, -6, -5};
		assertArrayEquals( expected, output );
	}

}
