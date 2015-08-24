import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MatrixTest {

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
	public void testAddElement() {
		
		Matrix testMatrix = new Matrix ( 3, 3 );
		testMatrix.addElements(2, 1, 6);
		assertEquals("", 6, testMatrix.data[2][1]);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testTranspose() {
		
		Matrix testMatrix = new Matrix ( 2, 2 );
		testMatrix.data[0][0] = 1;
		testMatrix.data[0][1] = 2;
		testMatrix.data[1][0] = 3;
		testMatrix.data[1][1] = 4;
		Matrix outputMatrix = testMatrix.transpose();
		int[][] expected = { {1,3}, {2,4} };
		int i, j;
		for(i=0; i<2; i++)
		{
			for(j=0; j<2; j++)
			{
				assertEquals("", expected[i][j], outputMatrix.data[i][j]);
			}
		}
	}

}
