class Solution {
    static int helper(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = 1;
        int ans = 1;

        for(int i=1; i<n; i++){
            int count = 0;
            for(int j=i-1; j>=0; j--){
                if(arr[i]>arr[j]) count = Math.max(count,dp[j]);
            }
            dp[i] = 1+count;
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    public int lengthOfLIS(int[] arr) {
        return helper(arr);
    }
}