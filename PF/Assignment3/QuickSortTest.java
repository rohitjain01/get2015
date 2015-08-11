import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class QuickSortTest {
	
	QuickSort qs = new QuickSort();			// Make object of QuickSort class

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

	@Test
	public void test1() {					// Test case 1
		
		int[] output = qs.quickSort ( new int[] {2, 5, 8, 9, 10, 77, 55, 11}, 7, 0 );
		assertArrayEquals( new int[] {2, 5, 8, 9, 10, 11, 55, 77}, output);
	}
	
	@Test
	public void test2() {					// Test case 2
		
		int[] output = qs.quickSort ( new int[] { }, 0, 0 );
		assertArrayEquals( new int[] { }, output);
	}

}
