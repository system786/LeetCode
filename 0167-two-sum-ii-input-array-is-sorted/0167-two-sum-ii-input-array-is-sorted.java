class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int i=0,j=numbers.length-1;
        while(i<j){
            if((numbers[i]+numbers[j])<target){
                i++;
            }else if((numbers[i]+numbers[j])>target){
                j--;
            }else{
                ans[0] = i+1;
                ans[1] = j+1;
                break;
            }
        }
        return ans;
    }
}