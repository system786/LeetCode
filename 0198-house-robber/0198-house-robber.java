class Solution {
    
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        var dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (var houseNum = 2; houseNum < nums.length; houseNum++) {
            dp[houseNum] = Math.max(dp[houseNum - 1], dp[houseNum - 2] + nums[houseNum]);
        }

        return dp[dp.length - 1];
    }
}