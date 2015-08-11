import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ComputeGcdTest {
	
	ComputeGcd cg = new ComputeGcd();		// Make object of ComputeGcd class 

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
		
		int output = cg.gcd ( 2, 1 );
		assertEquals( "", 1, output );
	}
	
	@Test
	public void test2() {					// Test case 2
		
		int output = cg.gcd ( 12, 18 );
		assertEquals( "", 6, output );
	}
	
	@Test
	public void test3() {					// Test case 3
		
		int output = cg.gcd ( 100, 3 );
		assertEquals( "", 1, output );
	}

}
