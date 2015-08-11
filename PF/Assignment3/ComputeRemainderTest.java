import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ComputeRemainderTest {
	
	ComputeRemainder cr = new ComputeRemainder(); // make object of ComputeRemainder Class

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
	public void test1() {				// Test case 1
		
		int output = cr.rem ( 2, 1 );
		assertEquals( "", 0, output );
	}
	
	@Test
	public void test2() {				// Test case 2
		
		int output = cr.rem ( 2, 0 );
		assertEquals( "", -1, output );
	}
	
	@Test
	public void test3() {				// Test case 3
		
		int output = cr.rem ( 100, 3 );
		assertEquals( "", 1, output );
	}

}
