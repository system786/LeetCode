class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0; // If the array length is less than or equal to 1, no jump is needed
        
        int count = 0; // Count of jumps
        int maxReach = 0; // Maximum index reachable with current jumps
        int nextReach = 0; // Maximum index reachable with one more jump

        for (int i = 0; i < n - 1; i++) {
            nextReach = Math.max(nextReach, i + nums[i]); // Update the maximum index reachable with one more jump
            
            if (i == maxReach) { // If we reach the end of the current jump range
                count++; // Increment the jump count
                maxReach = nextReach; // Update the maximum index reachable with current jumps
            }
        }
        
        return count;
    }
}