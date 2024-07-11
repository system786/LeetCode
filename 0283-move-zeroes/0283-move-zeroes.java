class Solution {
    public void moveZeroes(int[] arr) {
        int a=0;
        boolean found=false;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!=0) {
                arr[a]=arr[i];
                a++;
            }
            else {
                found=true;
            }
        }
        if(found==false) {
            return;
        }
        // sort(arr,a);
        for(int i=a;i<arr.length;i++) {
            arr[i]=0;
        }
    }
}