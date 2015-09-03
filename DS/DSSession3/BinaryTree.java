import java.util.*;

/**
 * DS Session 3 Assignment
 * BinaryTree.java
 * purpose : To check whether two trees are mirror images of each other or not 
 * @author Rohit
 *
 */
public class BinaryTree {

	int nodevalue;
	BinaryTree left;					// holds address of left child
	BinaryTree right;					// holds address of right child
	public BinaryTree root;         // root node
	int count = 1;
	ArrayList<Integer> inorderItem = new ArrayList<Integer>();	// take a array list to take items in inorder from tree
	BinaryTree()
	{
		root = null;						// at starting root is equals to null
	}
	BinaryTree insert ( BinaryTree node, int item )
	{
		if( node == null )			// if node is reached at null than make this new node
		{
			node = new BinaryTree();
			node.nodevalue = item;
			node.left = null;
			node.right = null;
			count++;
		}
		else
		{
			if( count%2 == 0 )					// if count%2 == 0 than go to left
			{
				node.left = insert( node.left, item );
			}
			else					// otherwise go to right
			{
				node.right = insert( node.right, item );
			}
		}
		return node;			// returns the node
	}
	ArrayList<Integer> inorder( BinaryTree node )
	{
		if( node != null )
		{
			inorder( node.left );
			inorderItem.add( node.nodevalue );			// add items in inorder form
			inorder( node.right );
		}
		return inorderItem;				// returns the list
	}
	void mirrorImage( BinaryTree tree2 )
	{
		ArrayList<Integer> list1, list2;
		int i;
		list1 = this.inorder( this.root );  // list1 holds first tree elements in inorder form
		list2 = tree2.inorder( tree2.root ); // list2 holds second tree elements in inorder form
		Collections.reverse(list2);				// reverse the contents of list2
		System.out.print("\n"+list1);
		System.out.print("\n"+list2);
		if( list1.size() == list2.size() )  // check whether list1 and list2 are equal or not
		{
			for(i=0; i<list1.size(); i++)
			{
				if(list1.get(i) != list2.get(i))
				{
					System.out.print("\n Not mirror image ");
					return;
				}
			}
			System.out.print("\n yes mirror image ");
		}
		else
		{
			System.out.print("\n Not mirror image");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int item, ch;
		Scanner sc = new Scanner(System.in);
		BinaryTree tree1 = new BinaryTree();
		BinaryTree tree2 = new BinaryTree();
		while(true) 										// menu for options
		{
			System.out.print("\n 1. Insert in first tree\n 2. Insertion in second tree\n 3. Check Mirror Image\n 4. Exit");
			System.out.print("\n Enter your choice : ");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.print("\n Enter node value : ");
				item = sc.nextInt();    						// enter items for first tree
				tree1.root = tree1.insert( tree1.root, item );
				break;
			case 2:
				System.out.print("\n Enter node value : ");
				item = sc.nextInt();							// insert items for second tree
				tree2.root = tree2.insert( tree2.root, item );
				break;
			case 3:
				tree1.mirrorImage(tree2); break;				// check tree1 and tree2 are mirror images or not
			case 5:
				System.exit(0); break;
			}
		}

	}

}
