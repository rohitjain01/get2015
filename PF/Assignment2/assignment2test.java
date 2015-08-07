import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class assignment2test {
	
	assignment2 a2= new assignment2();

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
	public void test1() {
		
		String s2=a2.spaces(3,5);
		assertEquals("Correct","   ",s2);
		//fail("Not yet implemented");
	}
	
	public void test2() {
		
		String s2=a2.numbers(3,5);
		assertEquals("Correct","12",s2);
	}
	
	public void test3() {
		
		String expected[]={"12345"," 1234","  123","   23","    3"};
		String output[]=a2.printpyramid(5);
		for(int i=0;i<9;i++){
			assertEquals("Correct",expected[i],output[i]);
		}
	}

}
