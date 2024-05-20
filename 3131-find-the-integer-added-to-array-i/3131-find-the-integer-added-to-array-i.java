class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        int sum2 =0;
        for(int num:nums2){
            sum2+=num;
        }
        
        int sum1 = 0;
        for(int num:nums1){
            sum1+=num;
        }
        
        return (sum2-sum1)/nums1.length;
    }
}