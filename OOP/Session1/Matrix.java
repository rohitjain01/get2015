import java.util.*;

/**
 * OOPs Session1 Assignment
 * Matrix.java
 * @author Rohit
 *
 */
public class Matrix {

	/**
	 * @param args
	 */
	
	public int data[][];
	int noRows;
	int noColumns;
	
	//Matrix class constructor used to initialize variables
	public Matrix( int row, int col)
	{
		this.noRows = row;
		this.noColumns = col;
		data = new int[row][col];
	}
	
	//addElement method used to add elements in matrix
	public void addElements ( int row, int col, int value )
	{
		data[row][col] = value;
	}
	
	//This method is used to transpose the Matrix
	public Matrix transpose()
	{
		Matrix mat2 = new Matrix ( noRows, noColumns );
		int i, j;
		for ( i=0; i<noRows; i++)
		{
			for ( j=0; j<noColumns; j++)
			{
				mat2.data[j][i] = data[i][j];
			}
		}
		
		return mat2;
	}
	
	//To show the elements of matrix after transpose
	public void show()
	{
		int i, j;
		System.out.println("\n Matrix is : ");
		for ( i=0; i<noRows; i++)
		{
			for ( j=0; j<noColumns; j++)
			{
				System.out.print(data[i][j]+" ");
			}
			System.out.print("\n");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner ( System.in );
		int rows, columns, i, j;
		System.out.print("\n Enter Rows in matrix : ");
		rows = sc.nextInt();
		System.out.print("\n Enter Columns in matrix : ");
		columns = sc.nextInt();
		Matrix mat = new Matrix( rows, columns);
		
		System.out.println("\n Enter Elements : ");
		for ( i=0; i<rows; i++ )
		{
			for( j=0; j<columns; j++ )
			{
				mat.addElements( i , j, sc.nextInt() );//call addElement method
			}
		}
		
		Matrix mat2 = mat.transpose();
		mat.show();
		mat2.show();
		sc.close();
		
	}

}
