package com.divideandconquer;
import divideandconquer.LinkedList.Node;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaxSubFinderTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void givenArrayTest() {
		int[] intArray = new int[]{13,-3,-25,-20,-3,-16,-23,18,
				20,-7,12,-5,-22,15,-4,7};
		Triple<Integer,Integer,Integer> res = MaxSubFinder.getMaxSubList(intArray,0,intArray.length-1);
		Integer expectedSum = res.getLast();
		assertEquals(expectedSum,res.getLast());
	}
	
	@Test
	public void givenLinkedTest() {
		int[] intArray = new int[]{13,-3,-25,-20,-3,-16,-23,18,
				20,-7,12,-5,-22,15,-4,7};
		LinkedList list = new LinkedList(intArray);
		Triple<Node,Node,Integer> res = MaxSubFinder.getMaxSubList(list);
		Integer expectedSum = 43;
		assertEquals(expectedSum,res.getLast());
	}

}
