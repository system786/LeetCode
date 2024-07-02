class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> f=new HashSet<>();
        int[] vis=new int[s.length()];
        for(String g: wordDict){
            f.add(g);
        }
        return get(new StringBuilder(),0,s.length(),f,s.toCharArray(),vis);
    }
    static boolean get(StringBuilder s, int i, int n, HashSet<String> f, char[] a,int[] vis){
        if(i==n){
            if(f.contains(s.toString())){
                return true;
            }
            return false;
        }
        s.append(a[i]);
         if(vis[i]==-1)return true;
         if(vis[i]==1)return get(s,i+1,n,f,a,vis);
        boolean t=false;
        if(f.contains(s.toString())){
            t=get(new StringBuilder(),i+1,n,f,a,vis);
            if(t){vis[i]=-1;return t;}
            vis[i]=1;
        }
         return get(s,i+1,n,f,a,vis);

    }
}