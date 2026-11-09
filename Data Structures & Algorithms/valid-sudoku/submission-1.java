class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    // Crate unique string identifiers for row, column, and sub-box
                    String b = "(" + current + ")";
                    if (!seen.add(i + "row" + b) || !seen.add(b + "col" + j) || !seen.add(i / 3 + "box" + j / 3 + b)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
