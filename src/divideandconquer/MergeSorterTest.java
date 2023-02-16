package divideandconquer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MergeSorterTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int[] nums = new int[]{4,3,2,1};
		int[] sorted = new int[] {1,2,3,4};
		MergeSorter.mergeSort(nums,0,nums.length-1);
		assertArrayEquals(sorted,nums);
	}

}
