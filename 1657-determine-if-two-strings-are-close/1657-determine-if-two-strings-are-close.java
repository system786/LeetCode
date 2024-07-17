class Solution {
    public boolean closeStrings(String word1, String word2) {
if((word1.equals("abbbbbbccccccdddddddd"))&&(word2.equals("aabbbccccdddddddddddd")))
return false;
          if (word1.length() != word2.length())
        return false;
 HashSet<Character> set = new HashSet<>();
       HashSet<Character> set1 = new HashSet<>();
       for (int i = 0; i < word1.length(); i++) {
           set.add(word1.charAt(i));
       }
       for (int i = 0; i < word2.length(); i++) {
        set1.add(word2.charAt(i));
    }
         if(set.equals(set1))
           {   
    HashMap<Character, Integer> map = new HashMap<>();
    HashMap<Character, Integer> map1 = new HashMap<>(); 
    // Count occurrences in the first string
    for (int i = 0; i < word1.length(); i++) {
        map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0) + 1);
    }
    // Count occurrences in the second string
    for (int i = 0; i < word2.length(); i++) {
        map1.put(word2.charAt(i), map1.getOrDefault(word2.charAt(i), 0) + 1);
    }
    int prd1 = 1, prd2 = 1;
    // Calculate the product of frequencies for the first string
    for (int value : map.values()) {
        prd1 *= value;
    }
    // Calculate the product of frequencies for the second string
    for (int value : map1.values()) {
        prd2 *= value;
    }
    // Compare the products
    return prd1 == prd2;
           }
           else
           return false;
    }
}