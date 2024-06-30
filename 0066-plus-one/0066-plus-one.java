class Solution {
    public int[] plusOne(int[] arr) {
       for(int i=arr.length-1;i>=0;i--){
            if(arr[i]+1<=9){
                arr[i]+=1;
                return arr;
            }else{
                arr[i]=0;
            }
       }
       int[] ar=new int[arr.length+1];
       ar[0]=1;
       return ar;
    }
}