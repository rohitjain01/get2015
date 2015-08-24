import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MainPersonTest {

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
	public void getUidTest() {
		
		Person personObj = new Person(23456789, "Rohit");
		assertEquals("", 23456789, personObj.getUid());
	}
	
	@Test
	public void getNameTest() {
		
		Person personObj = new Person(23456789, "Rohit");
		assertEquals("", "Rohit", personObj.getName());
	}
	
	@Test
	public void toStringTest() {
		
		Person personObj = new Person(23456789, "Rohit");
		String expected="\nName:Rohit\nuid:23456789";
		assertEquals("", expected, personObj.toString() );
	}

}
