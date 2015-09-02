import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BinarySerachTest {
	
	BinarySearch bs  = new BinarySearch();				// object of BinarySearch class
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
		int output1 = bs.leftMostOccurence( new Integer[]{2, 2, 2, 3, 4, 5}, 2, 0, 5);
		int output2 = bs.rightMostOccurence( new Integer[]{2, 2, 2, 3, 4, 5}, 2, 0, 5);
		assertEquals("", 0, output1);
		assertEquals("", 2, output2);
	}
	
	@Test
	public void test2() {
		int output1 = bs.leftMostOccurence( new Integer[]{2, 2, 2, 3, 4, 5}, 5, 0, 5);
		int output2 = bs.rightMostOccurence( new Integer[]{2, 2, 2, 3, 4, 5}, 5, 0, 5);
		assertEquals("", 5, output1);
		assertEquals("", 5, output2);
	}
	
	@Test
	public void test3() {
		int output1 = bs.leftMostOccurence( new Integer[]{1, 3, 3, 3, 4, 5}, 3, 0, 5);
		int output2 = bs.rightMostOccurence( new Integer[]{1, 3, 3, 3, 4, 5}, 3, 0, 5);
		assertEquals("", 1, output1);
		assertEquals("", 3, output2);
	}
	
	@Test
	public void test4() {
		int output1 = bs.leftMostOccurence( new Integer[]{1, 2, 2, 3, 4, 5}, 6, 0, 5);
		int output2 = bs.rightMostOccurence( new Integer[]{1, 2, 2, 3, 4, 5}, 6, 0, 5);
		assertEquals("", -1, output1);
		assertEquals("", -1, output2);
	}
	
	@Test
	public void test5() {
		int output1 = bs.leftMostOccurence( new Integer[]{1, 2, 2, 3, 4, 5, 5, 5, 5, 5}, 5, 0, 9);
		int output2 = bs.rightMostOccurence( new Integer[]{1, 2, 2, 3, 4, 5, 5, 5, 5, 5}, 5, 0, 9);
		assertEquals("", 5, output1);
		assertEquals("", 9, output2);
	}

}
