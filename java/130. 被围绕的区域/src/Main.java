public class Main {



    public boolean flag[][] = null;
    public int next[][] = {{1,0},{-1,0},{0,1},{0,-1}};

    public void dfs(char[][] board, int x, int y){
        flag[x][y] = true;
        for (int i = 0; i < 4; ++i){
            int xx = x + next[i][0];
            int yy = y + next[i][1];
            if (xx < 0 || xx >= board.length || yy < 0 || yy >= board[0].length || flag[xx][yy] || board[xx][yy] == 'X') continue;
            dfs(board,xx,yy);
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0) return;
        flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i){
            for (int j = 0; j < board[0].length; ++j){
                if (i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1){
                    if (board[i][j] == 'O')
                        dfs(board,i,j);
                }
            }
        }

        for (int i = 0; i < board.length; ++i){
            for (int j = 0; j < board[0].length; ++j){
                if (flag[i][j] == false){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
