class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pl = 1;
        int pr = 1;
        int[] res = new int[n];
        res[0] = pl;
        for(int i=1; i<n; i++){
            res[i] = res[i-1]*nums[i-1]; 
        }
        for(int i=n-1; i>=0; i--){
            res[i] *= pr;
            pr *= nums[i]; 
        }
        return res;
    }
}