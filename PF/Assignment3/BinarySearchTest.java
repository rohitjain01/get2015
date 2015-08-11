import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BinarySearchTest {
	
	BinarySearch bs = new BinarySearch();				// Make object of BinarySearch class

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
	public void test1() {							// Test case 1
		
		int output = bs.binarySearch ( new int[] {2, 5, 8, 9, 10, 55, 77}, 6, 0, 3, 88 );
		assertEquals( "", -1, output);
	}
	
	@Test
	public void test2() {							// Test case 2
		
		int output = bs.binarySearch ( new int[] {2, 5, 8, 9, 10, 55, 77}, 6, 0, 3, 77 );
		assertEquals( "", 7, output);
		
	}

}
