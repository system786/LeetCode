class Solution {
    public String longestPalindrome(String s) {
        int low ;
        int high ;
        int pal_len = 1;
        int pal_start = 0;

        for(int i = 0 ; i < s.length() ; i++){
            //even
            low = i;
            high = i + 1;

            while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){

                if(high - low + 1 > pal_len){
                    pal_start = low;
                    pal_len = high - low + 1;
                }

                low--;
                high++;
            }

            //odd
            low = i;
            high = i;

            while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){

                if(high - low + 1 > pal_len){
                    pal_start = low;
                    pal_len = high - low + 1;
                }
                low--;
                high++;
            }
        }

        return s.substring(pal_start, pal_start + pal_len);

    }
}