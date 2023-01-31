public class Main {



    public static int next[][] = {{0,1},{0,-1},{1,0},{-1,0}};

    public static boolean check(char[][] board, int x,int y, String word, int [][]flag){
        flag[x][y] = 1;
        if (word.length() == 0) return true;
        boolean res = false;
        for (int i = 0; i < 4; ++i){
            int xx =  x + next[i][0];
            int yy =  y + next[i][1];
            if (xx < 0 || xx >= board.length || yy < 0 || yy >= board[0].length) continue;
            if (board[xx][yy] == word.charAt(0) && flag[xx][yy] == 0){
                res = res || check(board,xx,yy,word.substring(1),flag);
            }
        }
        flag[x][y] = 0;
        return res;
    }

    public static boolean exist(char[][] board, String word) {
        boolean res = false;
        for (int  i = 0; i < board.length; ++i){
            for (int j  = 0; j < board[0].length; ++j){
                if (board[i][j] == word.charAt(0)){
                    res = res || check(board,i,j,word.substring(1),new int[board.length][board[0].length]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};
        System.out.println(exist(board,"ABCB"));
    }
}
