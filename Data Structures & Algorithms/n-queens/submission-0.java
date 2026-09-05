class Solution {    

    public boolean isSafe(char[][] board, int row, int col){

        int n = board.length;

        //check row --> east and west
        for(int j = 0;j<n;j++){
            if(board[row][j] == 'Q') return false;
        }

        //check col --> south and north
        for(int i = 0;i<n;i++){
            if(board[i][col] == 'Q') return false;
        }

         // check north east
        int i = row;
        int j = col;
        while(i>=0 && j<n){
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        
        //check south east
        i = row;
        j = col;
        while(i<n && j<n){
            if(board[i][j] == 'Q') return false;
            i++;
            j++;
        }

        //check south west
        i = row;
        j = col;
        while(i<n && j>=0){
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }

        // check north west
        i = row;
        j = col;
        while(i>=0 && j>=0){
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        return true;
    }

    public void helper(char[][] board, int row, List<List<String>> ans){
        int n = board.length;
        if(row == n){
            List<String> t = new ArrayList<>();
            for(int i = 0;i<n;i++){
                String str = "";
                for(int j = 0;j<n;j++){
                    str += board[i][j];
                }
                t.add(str);
            }
            ans.add(t);
            return;
        }

        for(int j = 0;j<n;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                helper(board,row+1,ans);
                board[row][j] = '.'; //backtracking
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        helper(board,0,ans);
        return ans;


    }
}
