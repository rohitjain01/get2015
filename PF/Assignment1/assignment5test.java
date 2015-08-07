package computer_fundamental;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class assignment5test {

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
		assignment5 test5=new assignment5();
		int output1=test5.checkArraySort(new int[]{1,2,3,4,5});
		int output2=test5.checkArraySort(new int[]{5,4,3,2,1});
		int output3=test5.checkArraySort(new int[]{1,2,4,3,5});
		assertEquals("",1,output1);
		assertEquals("",2,output2);
		assertEquals("",0,output3);
		//fail("Not yet implemented");
	}

}
