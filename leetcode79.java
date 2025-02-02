public class leetcode79 {
    public static void main(String[] args) {
        char[][] board ={
            {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };
        String word = "ABCCED";
        boolean ans = exist(board, word);
        System.out.println(ans);
    }
    public static boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for(int i =0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0))
                {
                    boolean[][] visited = new boolean[n][m];
                    if (dfs(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, String word, boolean[][] visited, int row, int col, int counter){
        if (counter == word.length()) {
            return true;
        }
        int n = board.length, m = board[0].length;
        if(row < 0 || col < 0 || row >= n|| col >= m|| counter >= word.length()|| board[row][col] != word.charAt(counter)|| visited[row][col]){
            return false;
        }
        visited[row][col] = true;

        boolean answer = dfs(board,word,visited,row+1,col,counter + 1) || dfs(board,word,visited,row-1,col,counter + 1) || dfs(board,word,visited,row,col+1,counter + 1) || dfs(board,word,visited,row,col-1,counter + 1);

        visited[row][col] = false;
        return answer;
    }
}
