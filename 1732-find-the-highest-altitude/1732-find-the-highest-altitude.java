class Solution {
    public int largestAltitude(int[] gain) {

        int i=0; int sum=0;int max=0;int j=0;
        while(i<gain.length){
             sum=sum+gain[i];
             max=Math.max(max,sum);

            gain[j]=sum;
             i++;
        }
     
        return max<0?0:max;
    }
}