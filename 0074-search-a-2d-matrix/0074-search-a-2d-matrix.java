class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length;
        int c=matrix[0].length;
        int low=0,high=(r*c-1);
        while(low<=high){
           int mid=low+(high-low)/2;
            int row=mid/c,col=mid%c;
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                low=mid+1;
            }
            else high=mid-1;
        }
        return false;
    }
}