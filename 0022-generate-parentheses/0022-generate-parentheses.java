class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> perm = new ArrayList<>();
        char [] temp = new char[n*2];
        generateParenthesis(n, n, temp, 0, perm);
        return perm;
    }

    public void generateParenthesis(int leftrem, int rightrem, char[] temp, int pos, List<String> perm) {
        if(leftrem<0 || rightrem<0 || leftrem>rightrem) return;

        if(leftrem==0 && rightrem==0 ) {
            perm.add(String.copyValueOf(temp));
        }

        if(leftrem>0) {
            temp[pos] ='(';
            generateParenthesis(leftrem-1, rightrem, temp, pos+1, perm);
        }

        if(rightrem> leftrem) {
            temp[pos] = ')';
            generateParenthesis(leftrem, rightrem-1, temp, pos+1, perm);
        }
    }
}