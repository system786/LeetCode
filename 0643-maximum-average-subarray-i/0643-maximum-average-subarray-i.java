class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double max=0;
        int s=0;
        for(int l=0;l<k;l++){
            s+=nums[l];
        }
        max=(double)s/k;
        int i=0,j=k;
        while(j<n){
            s-=nums[i];
            s+=nums[j];
            max=Math.max(max,(double)s/k);
            i++;
            j++;
        }
        return max;
    }
}
