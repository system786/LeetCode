class Solution {
    public boolean check(char c){
        if(c=='a' || c== 'e' || c== 'i' || c== 'o' || c== 'u')
            return true;
        return false;
    }
    public int maxVowels(String s, int k) {
        int i=0,cnt=0,ans=0;
        for(;i<k;i++)
        {
            if(check(s.charAt(i)))
                cnt++;
        }
        ans=cnt;
        for(;i<s.length();i++)
        {
            if(check(s.charAt(i)))
                cnt++;
            if(check(s.charAt(i-k)))
                cnt--;
             ans = Math.max(ans,cnt);
        }
        return ans;
    }
}