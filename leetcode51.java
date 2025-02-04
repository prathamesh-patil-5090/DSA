import java.util.ArrayList;
import java.util.List;

public class leetcode51 {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> kingList = solveNQueens(n);
        for (int i = 0; i < kingList.size(); i++) {
            for (int j = 0; j < kingList.get(0).size(); j++) {
                System.out.print(kingList.get(i).get(j) + " ");
            }
            System.out.println(); // New line after each row
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[][] grid = new int[n][n];
        solve(grid, 0, ans);
        return ans;
    }

    private static boolean isSafe(int[][] grid, int row, int col){
        for(int j = 0; j < col; ++j){
            if(grid[row][j] == 1) return false;
        }

        //Upper Diagaonal
        int tempRow = row, tempCol = col;
        while(tempRow >= 0 && tempCol >= 0){
            if(grid[tempRow][tempCol] == 1) return false;
            tempRow--;
            tempCol--;
        }

        //Lower Diagonal
        tempRow = row;
        tempCol = col;
        while(tempRow < grid.length && tempCol >= 0){
            if(grid[tempRow][tempCol] == 1) return false;
            tempRow++;
            tempCol--;
        }
        return true;
    }
    private static void solve(int[][] grid, int col, List<List<String>> ans){
        if(col == grid.length){
            List<String> currGrid = new ArrayList<>();
            for(int i = 0; i < grid.length; i++){
                char[] row = new char[grid.length];
                for(int j = 0; j < grid.length; ++j){
                    row[j] = grid[i][j] == 1 ? 'Q' : '.';
                }
                currGrid.add(new String(row));
            }
            ans.add(currGrid);
            return;  // explicit return for clarity
        }

        for(int i = 0; i < grid.length; ++i){
            if(isSafe(grid, i, col)){
                grid[i][col] = 1;
                solve(grid, col + 1, ans);
                grid[i][col] = 0;
            }
        }

    }
}
