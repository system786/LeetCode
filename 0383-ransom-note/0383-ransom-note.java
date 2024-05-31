class Solution {
    public boolean canConstruct(String r, String m) {
        int rArr[] = new int [26], mArr[] = new int [26];
        for(int i=0;i<r.length();i++){
            rArr[r.charAt(i)-'a']++;
        }
        for(int i=0;i<m.length();i++){
            mArr[m.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(rArr[i]>mArr[i]) return false;
        }
        return true;
    }
}