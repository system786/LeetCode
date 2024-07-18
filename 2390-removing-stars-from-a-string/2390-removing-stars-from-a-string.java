class Solution {
    public String removeStars(String s) {
        Stack<Character> res = new Stack<>();
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                res.push(s.charAt(i));

            } else {
                res.pop();
            }
        }
        for (char c : res) {
            s1.append(c);
        }
        return s1.toString();
    }
}