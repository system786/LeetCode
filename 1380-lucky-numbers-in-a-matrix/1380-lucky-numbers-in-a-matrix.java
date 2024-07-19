class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        int m=matrix.length;
        int k,ind=0;
        for(int i=0;i<m;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<matrix[i].length;j++){
               if(matrix[i][j]<min){
                  min=matrix[i][j];
                  ind=j;
               }
            }
            for( k=0;k<m;k++){
                if(matrix[k][ind]>min) break;
            }if(k==m)result.add(min);
        }
        return result;
    }
}