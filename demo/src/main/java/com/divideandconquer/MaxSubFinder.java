package com.divideandconquer;

import java.util.ArrayList;
import java.util.List;

import divideandconquer.LinkedList.Node;

public class MaxSubFinder {

	@SuppressWarnings("unchecked")
	public static Triple<Node, Node, Integer> getMaxSubList(LinkedList list) {
		// TODO Auto-generated method stub
		int[] n =(int[]) list.getArray();
		
	    Triple<Integer,Integer,Integer> res = MaxSubFinder.getMaxSubList(n,0,n.length-1);
		Integer g = res.getLast();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Triple t = new Triple(res.getFirst(),res.getMiddle(),g);
	    return t;
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Triple<Integer, Integer, Integer> getMaxSubList(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if (low == high) {
            // base case: array of size 1
			Triple t = new Triple(low,high,arr[low]);
	        return t;
            
        } else {
            int mid = (low + high) / 2;

            // find the maximum subarray in the left half of the array
            Triple<Integer, Integer, Integer> leftResult = getMaxSubList(arr, low, mid);

            // find the maximum subarray in the right half of the array
            Triple<Integer, Integer, Integer> rightResult = getMaxSubList(arr, mid + 1, high);

            // find the maximum subarray that crosses the midpoint
            Triple<Integer, Integer, Integer> crossResult = findMaxCrossing(arr, low, mid, high);

            // return the result with the maximum sum
            if (leftResult.getLast() >= rightResult.getLast() && leftResult.getLast() >= crossResult.getLast()) {
                return leftResult;
            } else if (rightResult.getLast() >= leftResult.getLast() && rightResult.getLast() >= crossResult.getLast()) {
                return rightResult;
            } else {
                return crossResult;
            }
        }
    }

    // function to find the maximum subarray that crosses the midpoint
    @SuppressWarnings("unchecked")
	public static Triple<Integer, Integer, Integer> findMaxCrossing(int[] arr, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = 0;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += arr[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }

        
        @SuppressWarnings({ "rawtypes", "unchecked" })
		Triple t = new Triple(maxLeft,maxRight,leftSum+rightSum);
        return t;
    }
		

}
