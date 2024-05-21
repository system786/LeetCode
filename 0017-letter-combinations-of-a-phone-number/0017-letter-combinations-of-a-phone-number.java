class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> digitToLetters = initializeMap();
        List<String> combinations = new ArrayList<>();
        if (digits.length() > 0) solve(0, digits, digitToLetters, "", combinations);
        return combinations;
    }

    private Map<Character, String> initializeMap() {
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        return digitToLetters;
    }

    private void solve(int idx, String digits, Map<Character, String> digitToLetters, String charsSoFar,
            List<String> combinations) {

        if (idx == digits.length()) {
            combinations.add(charsSoFar);
            return;
        }

        String digitLetters = digitToLetters.get(digits.charAt(idx));

        for (int i = 0; i < digitLetters.length(); i++) {
            char curr = digitLetters.charAt(i);
            solve(idx + 1, digits, digitToLetters, charsSoFar + curr, combinations);
        }
    }
}