import java.util.*;

/**
 * DS Session 3 Assignment
 * Preorder.java
 * @author Rohit
 *
 */
public class Preorder {

	int nodevalue;				// to holds value of node 
	Preorder left;				// to holds address of left child
	Preorder right;				// to holds address of right child
	
	static Preorder root = null;			// root node
	Preorder insert( int item, Preorder node )
	{
		if( node == null )				// if node reached at null position than insert node at that position
		{
			node = new Preorder();
			node.nodevalue = item;
			node.left = null;
			node.right = null;
		}
		else
		{
			if( item < node.nodevalue )				// if value of item is less than node value than go to left 
			{
				node.left = insert( item, node.left );
			}
			else									// else go to right
			{
				node.right = insert( item, node.right );
			}
		}
		return node;
	}
	void preorder( Preorder node )
	{
		if( node != null )
		{
			System.out.print(node.nodevalue+" ");		// first print node value
			preorder( node.left );						// call method recursively for node.left 
			preorder( node.right );						// call method recursively for node.right 
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int item;
		Preorder tree = new Preorder();
		int ch;
		Scanner sc = new Scanner(System.in);
		while(true)						// make a menu for selecting options
		{
			System.out.print("\n 1. insert\n 2. Preorder\n 3.Exit");
			System.out.print("\n Enter your choice : ");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.print("\n Enter node value : ");
				item = sc.nextInt();
				root = tree.insert(item, root);			// call insert method
				break;
			case 2:
				System.out.print("\nPreorder traversal is : ");
				tree.preorder(root); break;			// call preorder
			case 3:
				System.exit(0);
			}
		}

	}

}
