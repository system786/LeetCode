class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)  return 0;
        if(nums.length==1)  return 1;
        
        Arrays.sort(nums); 
        nums=Arrays.stream(nums).distinct().toArray();
        int count=1,max=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]==1){
                count++;
                max=Math.max(count,max);
            }else{
                count=1;
            }
        }
        return max;
    }
}