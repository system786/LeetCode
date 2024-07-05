class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1=s1.length(),n2=s2.length(),n3=s3.length();
        if(n1+n2!=n3) return false;
        Boolean[][] memo = new Boolean[n1 + 1][n2 + 1];
        return interleaving(s1,s2,s3,0,0,0,memo);
    }
    public boolean interleaving(String s1, String s2, String s3,int i,int j,int k,Boolean[][] memo){
        if(k==s3.length()) return true;
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        boolean res=false;
        if(i<s1.length()&&j<s2.length()&&s1.charAt(i)==s3.charAt(k)&&s2.charAt(j)==s3.charAt(k)){
            res=interleaving(s1,s2,s3,i+1,j,k+1,memo)||interleaving(s1,s2,s3,i,j+1,k+1,memo);
        }else if(i<s1.length()&&s1.charAt(i)==s3.charAt(k)){
            res=interleaving(s1,s2,s3,i+1,j,k+1,memo);
        }else if(j<s2.length()&&s2.charAt(j)==s3.charAt(k)){
             res=interleaving(s1,s2,s3,i,j+1,k+1,memo);
        }
        memo[i][j] = res;
        return res;      
    }
}