class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //sliding window with a hashset
        Queue<Integer> q = new LinkedList();
        HashSet<Integer> set = new HashSet();
        //preprocess for 1st k elements
        for(int i=0;i<=Math.min(k, nums.length-1);i++){
            q.add(nums[i]);
            if(set.contains(nums[i])) {
                return true;
            } else{ 
                set.add(nums[i]);
            }
        }
        //process rest of the elements
        for(int i=k+1;i<nums.length;i++){
            set.remove(q.remove());
            q.add(nums[i]);
            if(set.contains(nums[i])) {
                return true;
            } else{ 
                set.add(nums[i]);
            }
        }
        return false;
    }
}