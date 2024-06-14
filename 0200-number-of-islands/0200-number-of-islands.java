class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < row;i++){
            for(int j = 0; j < col ; j++){
                if(grid[i][j] == '1'){
                    count = count + 1;
                    dfs(grid,i,j,row,col);
                }
            }
        }
        return count;
    }
    public static void dfs(char[][] grid,int i , int j,int row,int col){
      if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') return; //check for base state index out of bound,hitting 0 
      //or water so recursion stops
     
     grid[i][j] = '0'; //changing to value of 1 to 0 when recorded

     dfs(grid,i + 1,j,row,col);
     dfs(grid,i - 1,j,row,col);
     dfs(grid,i,j+1,row,col);
     dfs(grid,i,j-1,row,col);

    }

    }