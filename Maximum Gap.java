// link: https://leetcode.com/problems/maximum-gap/description/

// Given an integer array nums, return the maximum difference between two successive elements in its sorted form. 
// If the array contains less than two elements, return 0.
// You must write an algorithm that runs in linear time and uses linear extra space.



class Bucket {

	public Bucket(int[] nums) {
		int n = nums.length;
		int minV = Integer.MAX_VALUE;
		int maxV = 0;

		for (int i = 0; i < n + 1; i++) {
			buckets.put(i, new ArrayList());
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < minV) minV = nums[i];
			if (nums[i] > maxV) maxV = nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			int numberBucket = nums[i] / maxV * n;
			buckets.get(numberBucket).add(nums[i]);
		}

		for (int i = 0; i < n + 1; i++) {
			Collections.sort(buckets.get(i));
		}


		for (int i = 0; i < n + 1; i++) {
			res.addAll(buckets.get(i));
		}
	}

	Map<Integer, List<Integer>> buckets = new HashMap();
	public List<Integer> res = new ArrayList();

}

class Solution {
	public int maximumGap(int[] nums) {
		Bucket bucket = new Bucket(nums);
		List<Integer> a = bucket.res;

		int diff = 0;

		if (a.size() <= 1) {
			return 0;
		}

		for (int i = 1; i < a.size(); i++) {
				diff = Math.max(diff, a.get(i) - a.get(i - 1));
		}
		return diff;
	}
}
