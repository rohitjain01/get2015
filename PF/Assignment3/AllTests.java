import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ BinarySearchTest.class, ComputeGcdTest.class,
		ComputeRemainderTest.class, LargestDigitTest.class,
		LinearSearchTest.class, QuickSortTest.class })
public class AllTests {

}
