class Solution {
    public boolean isSubsequence(String s, String t) {
        // check if strings are equals by length if yes check equality of s and t
        if(t.length() == s.length()) return s.equals(t);
        // check that s is longer than t if yes, return false, since we can't finde subsequence of larger string in smaller
        if(s.length() > t.length()) return false;
        // declare left and right pointers
        int l = 0, r = 0;
        // iterate in while loop until the end of s string
        while(l < s.length()) {
            // check if we reach end of t string with right pointer, if yes return false
            if(r == t.length()) return false;
            // take char from s string with left pointer and increment it
            char lc = s.charAt(l++);
            // take char form t string with right pointer and increment it
            char rc = t.charAt(r++);
            // enter inner loop until left char and right char are not equals
            while(lc != rc) {
                // again check if right pointer is in boundary of t string, if false return false
                if(r == t.length()) return false;
                // take next char from t string with right pointer and increment it
                rc = t.charAt(r++);
            }
        }
        // if we reach this stage then we found subsequence of s in t
        return true;
    }
}