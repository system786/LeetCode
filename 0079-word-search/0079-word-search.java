class Solution {
    boolean ans = false;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int pos, int i, int j) {
        if (pos == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(pos)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' '; // Mark as visited
        boolean found = search(board, word, pos + 1, i + 1, j) ||
                        search(board, word, pos + 1, i - 1, j) ||
                        search(board, word, pos + 1, i, j + 1) ||
                        search(board, word, pos + 1, i, j - 1);
        board[i][j] = temp; // Restore original character
        return found;
    }
}