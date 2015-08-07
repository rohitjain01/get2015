import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class assignment1test {
	
	assignment1 a1= new assignment1();

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
		
		String s1=a1.spaces(3,5);
		assertEquals("Correct"," ",s1);
		//fail("Not yet implemented");
	}
	
	public void test2() {
		
		String s1=a1.numbers(3,5);
		assertEquals("Correct","1234321",s1);
		
	}
	
	public void test3() {
		
		String expected[]={"    1","   121","  12321"," 1234321","123454321"," 1234321","  12321","   121","    1"};
		String s1[]=a1.printpyramid(5);
		for(int i=0;i<9;i++){
			assertEquals("Correct",expected[i],s1[i]);
		}
		
	}

}
