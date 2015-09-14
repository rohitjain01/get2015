import java.util.*;
/**
 * DS Session 8 Assignment
 * BinarySearchTree.java
 * @author Rohit
 *
 */
public class BinarySearchTree {

	int nodevalue;				// to holds value of node 
	BinarySearchTree left;				// to holds address of left child
	BinarySearchTree right;				// to holds address of right child
	static ArrayList<Integer> inorderList = new ArrayList<Integer>();
	
	static BinarySearchTree root = null;			// root node
	BinarySearchTree insert( int item, BinarySearchTree node )
	{
		if( node == null )				// if node reached at null position than insert node at that position
		{
			node = new BinarySearchTree();
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
	ArrayList<Integer> inorder( BinarySearchTree node )
	{
		if( node != null )// If node equals to null
		{
			inorder( node.left ); // than call the method recusively with go to left node
			inorderList.add( node.nodevalue ); // than add the node value in list
			inorder( node.right ); // than call method recusively with go to right
		}
		return inorderList;  // return the list
	}
}