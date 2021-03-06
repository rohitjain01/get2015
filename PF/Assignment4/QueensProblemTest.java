import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class QueensProblemTest {

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
		
		QueensProblem testObject1 = new QueensProblem(4);
		int expected[][] = { {'0', '0', '1', '0'}, {'1', '0', '0', '0'}, {'0', '0', '0', '1'}, {'0', '1', '0', '0'} };
		int actual[][] = testObject1.callplaceNqueens();
		QueensProblemTest test = new QueensProblemTest();
		int result=test.compare(expected, actual);
		assertEquals("", 1,result);
		//fail("Not yet implemented");
	}
	
	public int compare(int[][] expected, int[][] actual)
	{
		int result=1;
		int length = expected.length;
		for(int i=0;i<length;i++)
		{
			for(int j=0;j<length;j++)
			{
				if(expected[i][j]!=actual[i][j])
				{
					result = 0;
					System.out.print(actual[i][j]+"\t");
					return result;
					
				}
			}
			System.out.println();
		}
		return result;
	}

}
