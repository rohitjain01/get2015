import java.util.Scanner;

/**
 * DS Session 3 Assignment
 * Postorder.java
 * @author Rohit
 *
 */
public class Postorder {

	int nodevalue;             // to holds value of node 
	Postorder left;            // to holds address of left child
	Postorder right;           // to holds address of right child
	
	static Postorder root = null;  // root node
	Postorder insert( int item, Postorder node )
	{
		if( node == null )   // if node reached at null position than insert node at that position
		{
			node = new Postorder();
			node.nodevalue = item;
			node.left = null;
			node.right = null;
		}
		else
		{
			if( item < root.nodevalue )
			{
				node.left = insert( item, node.left );    // if value of item is less than node value than go to left
			}
			else
			{
				node.right = insert( item, node.right );   // else go to right
			}
		}
		return node;
	}
	void postorder( Postorder node )
	{
		if( node != null )
		{
			
			postorder( node.left );   // call method recursively for node.left 
			postorder( node.right );  // call method recursively for node.right 
			System.out.print(node.nodevalue+" ");  // first print node value
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int item;
		Postorder tree = new Postorder();
		int ch;
		Scanner sc = new Scanner(System.in);
		while(true)    // make a menu for selecting options
		{
			System.out.print("\n 1. insert\n 2. Postorder\n 3. Exit");
			System.out.print("\n Enter your choice : ");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.print("\n Enter node value : ");
				item = sc.nextInt();
				root = tree.insert(item, root);   // call insert method
				break;
			case 2:
				System.out.print("\nPostorder traversal is : ");
				tree.postorder(root); break;     // call postorder
			case 3:
				System.exit(0);
			}
		}

	}

}
