class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> obj=new LinkedList<>();
        int a=matrix.length;
        int b=matrix[0].length;
        int max=Math.max(a,b);
        int s=(max+1)/2;
        int i,j,k;
        max=a*b;
        for(i=0;i<s;i++)
        {
            if(max==0)
            break;
            for(j=i;j<=b-i-1;j++)
            {
                obj.add(matrix[i][j]);
                max--;
            }
            if(max==0)
            break;
            for(k=i+1;k<=a-1-i;k++)
            {
                obj.add(matrix[k][b-i-1]);
                max--;
            }
            if(max==0)
            break;
            for(j=b-i-2;j>=i;j--)
            {
                obj.add(matrix[a-i-1][j]);
                max--;
            }
            if(max==0)
            break;
            for(k=a-i-2;k>i;k--)
            {
                obj.add(matrix[k][i]);
                max--;
            }
            if(max==0)
            break;
        }
        return obj;
    }
}