class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        
        for(int i = 0; i < arr.length-2; i++) {
            int prod = arr[i] * arr[i+1] * arr[i+2];

            if(prod % 2 == 1) return true;
        }
        return false;
    }
}