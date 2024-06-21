class Solution {
    
    public Node createNode(int[][] grid,int[] tl, int[] tr,int[] bl){
        int cells = 0, sum = 0, i = 0, j =0;
        
        for(i=tl[0];i<=bl[0];i++){
            for(j=tl[1];j<=tr[1];j++){
                cells++;
                sum+=grid[i][j];
            }
        } 
        int n = bl[0]-tl[0]+1, m = tr[1]-tl[1]+1;
        int[] br= { bl[0] ,tr[1]};
        // System.out.println(cells+" "+sum+" "+tl[0]+" "+tl[1]+" "+bl[0]+" "+br[1]);
        Node node ;
        if( (cells == sum ) || sum == 0 ){
            node = new Node((sum>0)?true:false,true);
            return node;
        }
        int mid = n/2;

        int[] upperHorizontalMid = {tl[0], (tl[1]+tr[1]) / 2 };
        int[] leftVerticalMid = { (tl[0]+bl[0]) /2, tl[1] };
        int[] center = { ((tl[0]+bl[0]) /2 ) ,((tl[1]+tr[1]) / 2)   +1};
        int[] rightVerticalMid = {((tr[0]+br[0])/2)+1,tr[1]};
        int[] lowerHorizontalMid = { bl[0], ((bl[1]+br[1]) /2 )+1 };
        Node topLeftNode = createNode(grid, tl, upperHorizontalMid, leftVerticalMid );
        upperHorizontalMid[1]++;
        Node topRightNode = createNode(grid,upperHorizontalMid,tr, center );
        leftVerticalMid[0]++;
        center[0]++;
        center[1]--;
        Node bottomLeftNode = createNode(grid,leftVerticalMid, center,bl );
        center[1]++;
        
        Node bottomRightNode = createNode(grid, center, rightVerticalMid,lowerHorizontalMid);
        
        node = new Node(true,false, topLeftNode, topRightNode, bottomLeftNode, bottomRightNode);
        
        return node;
        
        
    }
    
    public Node construct(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int mid = n/2;
        int[] tl = {0,0}, tr = {0,n-1}, bl = {n-1,0}, br = {bl[0],tr[1]};
        
        return createNode(grid,tl,tr,bl);

    }
}