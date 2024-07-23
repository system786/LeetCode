class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> freq = new HashMap<>();
        Integer[] newNums = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            newNums[i] = nums[i];
        }

        // Step 2: Sort the array using a custom comparator
        Arrays.sort(newNums, (n1, n2) -> {
            if (!freq.get(n1).equals(freq.get(n2))) {
                return freq.get(n1) - freq.get(n2); // Sort by frequency (ascending)
            } else {
                return n2 - n1; // Sort by value (descending) if frequencies are the same
            }
        });

        // Step 3: Convert back to int[] array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }

        return nums;
    }
}