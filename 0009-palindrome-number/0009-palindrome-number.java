class Solution {
    public boolean isPalindrome(int x) {
      String str = Integer.toString(x);
        StringBuffer sc = new StringBuffer(str);
        sc.reverse();
        String s = sc.toString();
        if(str.equals(s)){
            return true;
        }
        return false;  
    }
}