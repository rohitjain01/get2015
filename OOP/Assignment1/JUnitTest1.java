import static org.junit.Assert.*;

import org.junit.Test;


public class JUnitTest1 {

	@Test
	public void test() {
		Matrix matrixActual= new Matrix(3,3);
		matrixActual.addElements(0, 0, 1);
		matrixActual.addElements(0, 1, 1);
		matrixActual.addElements(0, 2, 1);
		matrixActual.transpose();
		int transposeActual[][]=matrixActual.data;
		int transposeExpected[][]={{1,0,0},{1,0,0},{1,0,0}};
		
		assertEquals("",1,isArrayEqual(transposeExpected, transposeActual));
	}
	
	
	public int isArrayEqual(int expected[][], int actual[][])
	{
		int result=1;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(expected[i][j]!=actual[i][j])
				{
					result=0;
				}
			}
		}
		return result;
	}
	

}
