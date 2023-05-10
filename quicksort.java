package com.example.leetcode;

import java.util.Arrays;

public class Code {
	public static void main(String[] args) {
//		int[] input = new int[] {6, 5, 4, 3, 2, 1, 0};
//		int[] input = new int[] {4,5,6,7,0,1,4};
		int[] input = new int[] {-9,6,-6,-6,-6,-6,-5-4,-3,-3,-3,-3,0,10,10,10,-10,-9,-9,-9,-9};
		System.out.println(findMin(input));
	}

	public static int findMin(int[] nums) {
		int start = 0;
		int end = nums.length;
		sort(nums, start, end - 1);
		System.out.println(Arrays.toString(nums));
		return nums[0];
	}

	public static void sort(int[] nums, int s, int e) {

		if (s >= e) return;

		int currS = s;
		int currE = e;
		int avr = nums[(s+e)/2];
		while (currS <= currE) {
			if (nums[currS] >= avr && nums[currE] <= avr) {
				int tmp = nums[currE];
				nums[currE] = nums[currS];
				nums[currS] = tmp;
			}
			if (nums[currS] <= avr) currS++;
			if (nums[currE] >= avr) currE--;
		}
		sort(nums, s, currE);
		sort(nums, currS, e - 1);
	}
}
