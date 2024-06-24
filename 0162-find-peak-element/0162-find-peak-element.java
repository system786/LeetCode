class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 0;
        }
        int mid=0;
        int l=0,r=n-1;
        while(l<=r){
            mid=(l+r)/2;
            if(mid>0 && mid<n-1 && nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(mid<n-1 && nums[mid]<nums[mid+1]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        else{
            return n-1; 
        }
    }
}