class Solution {
    public int maxPoints(int[][] points) {
        int n=points.length;
        if(n==1) return 1; 
        int max_c=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1=points[i][0];
                int y1=points[i][1];
                int x2=points[j][0];
                int y2=points[j][1];
                int c=0;
                for(int k=0;k<n;k++){
                    if((points[k][1]-y1)*(x2-x1)==(y2-y1)*(points[k][0]-x1)) c++;
                    }
                max_c=Math.max(max_c,c);
            }
        }
        return max_c;
    }
}