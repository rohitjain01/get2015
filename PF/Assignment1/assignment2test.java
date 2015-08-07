package computer_fundamental;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class assignment2test {

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
	public void test() {
		
		assignment2 test2=new assignment2();
		int []output=test2.removeDuplicate(new int[]{2,5,4,6,3,8,5,9,3,3,6,3,9,0});
		assertArrayEquals(new int[]{2,5,4,6,3,8,9,0},output);
		//fail("Not yet implemented");
	}

}
