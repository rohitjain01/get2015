import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class LinearSearchTest {
	
	LinearSearch ls = new LinearSearch();			// Make object of LinearSearch class

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
	public void test1() {						// Test case 1
		
		int output = ls.linearSearch ( new int [] {2,5,8,9,10, 77, 55}, 88 );
		assertEquals( "", -1, output);
	}
	
	@Test
	public void test2() {						// Test case 2
		
		int output = ls.linearSearch ( new int [] {2, 5, 8, 9, 10, 77, 55, 11}, 77 );
		assertEquals( "", 6, output);
		
	}

}
