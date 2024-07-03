class Solution {
    public int minDifference(int[] nums) {
        // Base CAse..
        if (nums.length < 5)
            return 0;

        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, nums[nums.length - 4 + i] - nums[i]);
        }
        return res;
    }
}