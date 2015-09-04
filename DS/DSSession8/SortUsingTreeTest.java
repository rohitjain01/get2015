import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SortUsingTreeTest {

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
	public void inorderTestPositive() {
		
		int numberOfStudents = 10;
		List<Integer> sortedListExpected = new ArrayList<Integer>();
		for(int i = 0; i < numberOfStudents; i++) {
			sortedListExpected.add(i+1);
		}
		BinarySearchTree treeSortStudentObj = new BinarySearchTree();
		BinarySearchTree.root = treeSortStudentObj.insert(10, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(9, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(8, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(7, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(6, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(5, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(4, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(3, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(2, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(1, BinarySearchTree.root);
		
		assertEquals(sortedListExpected, treeSortStudentObj.inorder(BinarySearchTree.root));
		
	}
	
	@Test
	public void inorderTestNegative() {
		
		int numberOfStudents = 10;
		List<Integer> sortedListExpected = new ArrayList<Integer>();
		for(int i = 0; i < numberOfStudents; i++) {
			sortedListExpected.add(i);
		}
		BinarySearchTree treeSortStudentObj = new BinarySearchTree();
		BinarySearchTree.root = treeSortStudentObj.insert(10, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(9, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(8, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(7, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(6, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(5, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(4, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(3, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(2, BinarySearchTree.root);
		BinarySearchTree.root = treeSortStudentObj.insert(1, BinarySearchTree.root);
		
		assertNotEquals(sortedListExpected, treeSortStudentObj.inorder(BinarySearchTree.root));
		
	}
	
	
	@Test
	public void inorderNullTestPositove() {
		
		List<Integer> sortedListExpected = new ArrayList<Integer>();
		BinarySearchTree treeSortStudentObj = new BinarySearchTree();
		assertEquals(sortedListExpected, treeSortStudentObj.inorder(BinarySearchTree.root));
		
	}
	
	@Test
	public void inorderNullTestNegative() {
		
		BinarySearchTree treeSortStudentObj = new BinarySearchTree();
		assertNotEquals(0, treeSortStudentObj.inorder(BinarySearchTree.root));
		
	}
	

	@Test
	public void insertTestNegative() {
		
		List<Integer> sortedListExpected = new ArrayList<Integer>();
		sortedListExpected.add(6);
		BinarySearchTree treeSortStudentObj = new BinarySearchTree();
		BinarySearchTree.root = treeSortStudentObj.insert(10, BinarySearchTree.root);
		assertNotEquals(sortedListExpected, treeSortStudentObj.inorder(BinarySearchTree.root));
		
	}

}
