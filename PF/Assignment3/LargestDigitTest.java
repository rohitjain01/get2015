import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class LargestDigitTest {
	
	LargestDigit ld = new LargestDigit();			// Make object of LargestDigit class

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
		
		int output = ld.largestDigit ( 2 );
		assertEquals( "", 2, output );
	}
	
	@Test
	public void test2() {						// Test case 2
		
		int output = ld.largestDigit ( 1257369 );
		assertEquals( "", 9, output );
	}
	
	@Test
	public void test3() {						// Test case 3
		
		int output = ld.largestDigit ( 444 );
		assertEquals( "", 4, output );
	}

}
