package computer_fundamental;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class assignment6test {

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
		assignment6 test6=new assignment6();
		int c[]=new int[10];
		int []output=test6.join(new int[]{1,2,4,7,8}, 5, new int[]{3,5,6,9,10}, 5, c);
		assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10},output);
		//fail("Not yet implemented");
	}

}
