class Solution {
    public void dfs(char[][] board,boolean[][] vis,int i,int j,int m,int n){
        if(i<0||j<0||i>=m||j>=n||vis[i][j]||board[i][j]=='X')
        return;
        vis[i][j]=true;
        dfs(board,vis,i+1,j,m,n);
        dfs(board,vis,i-1,j,m,n);
        dfs(board,vis,i,j+1,m,n);
        dfs(board,vis,i,j-1,m,n);
    }

    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean vis[][]=new boolean[m][n];
       for(int j=0;j<n;j++){
           if(board[0][j]=='O'&&!vis[0][j])
           dfs(board,vis,0,j,m,n);
           if(board[m-1][j]=='O'&&!vis[m-1][j])
            dfs(board,vis,m-1,j,m,n);
       }
        for(int i=0;i<m;i++){
           if(board[i][0]=='O'&&!vis[i][0])
           dfs(board,vis,i,0,m,n);
           if(board[i][n-1]=='O'&&!vis[i][n-1])
            dfs(board,vis,i,n-1,m,n);
       }

       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(!vis[i][j]&&board[i][j]=='O')
               board[i][j]='X';
           }
       }

    }
}