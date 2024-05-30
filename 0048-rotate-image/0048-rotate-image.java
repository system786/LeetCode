class Solution {
    public void rotate(int[][] matrix) {
        int k=matrix.length;
        int temp;
        for(int i=0;i<k;i++){
            for(int j=i;j<k;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
                
            }
        }
        for(int x=0;x<matrix.length;x++){
            int left=0;
            int right=matrix.length-1;
            while(left<right){
                temp=matrix[x][right];
                matrix[x][right]=matrix[x][left];
                matrix[x][left]=temp;
                left++;
                right--;
                
            }
        }

    }
}