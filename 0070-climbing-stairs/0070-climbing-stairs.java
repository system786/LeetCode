class Solution {
    public int climbStairs(int n) {
        if(n<=1) return 1;
        int prev = 1;
        int prevtoprev = 1;
        int curr = -1;
        for(int i = 2;i<=n;i++){
            curr = prev + prevtoprev;
            prevtoprev = prev;
            prev = curr;
        }
        return curr;
    }
}