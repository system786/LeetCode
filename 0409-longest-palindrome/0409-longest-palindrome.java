class Solution 
{
    public int longestPalindrome(String s) 
    {
        int n = s.length();
        int[] cntArray = new int[52];
        int longestPalinLen = 0;
        Arrays.fill(cntArray, 0);
        for(int i = 0; i < n; i ++)
        {
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z')
            {
                cntArray[ch-'a']++;
            }
            else 
            {
                cntArray[ch-'A'+26]++;
            }
        }
        // if frequency is even add it in your answer
        // if frequecy is odd, consider even count by subtracting 1
        // finally if atleast one odd character is found, add 1 to your answer
        boolean isOddFound = false;
        for(int i = 0; i < 52; i ++)
        {
            if((cntArray[i] % 2) == 0)
            {
                longestPalinLen += cntArray[i];
            }
            else
            {
                longestPalinLen += (cntArray[i]-1);
                isOddFound = true;
            }
        }
        longestPalinLen = (isOddFound)?(++longestPalinLen):longestPalinLen;
        return longestPalinLen;
    }
}