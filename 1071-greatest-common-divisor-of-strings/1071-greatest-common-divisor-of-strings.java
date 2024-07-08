class Solution {
    int gcd(int n, int m) {
        while (m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }
        return n;
    }
    public String gcdOfStrings(String str1, String str2) {
        if((str1+str2).equals(str2+str1)){
            String ag="";
            int index=gcd(str1.length(),str2.length());
            return str1.substring(0,index);
        }
        return "";
    }
}