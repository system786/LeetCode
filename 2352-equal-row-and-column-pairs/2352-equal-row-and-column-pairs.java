class Solution {
    public boolean helper(int []row , int []col)
    {
        for( int i = 0 ;  i  < row.length ; i++)
        {
             if(row[i] != col[i]) return false;
        }
        return true;
    }
    public int equalPairs(int[][] row) {
        int col [][]= new int [row.length][row.length];
        for ( int i = 0 ; i < row.length ; i++)
        {   int tem[] = new int [row.length];
            for ( int j = 0 ; j< row.length ; j++)
            {
                tem[j] = row[j][i];
            }
            col[i] =tem;
        }
        int count =0;
        for ( int i = 0 ; i < row.length ; i++)
        {
            for( int j =0 ; j < row.length ; j++)
            {
                if (helper(row[i],col[j]))
                {
                    count++;
                }
            }
        }
        return count;
        
    }
}