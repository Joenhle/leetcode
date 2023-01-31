public class Main {

    int next[][] = {{0,1},{0,-1},{1,0},{-1,0}};

    void dfs(char[][] grid,int x, int y){
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++){
            int xx = x + next[i][0];
            int yy = y + next[i][1];
            if (xx < 0 || xx >= grid.length || yy < 0 || yy > grid[1].length) continue;
            if (grid[xx][yy] == '1'){
                dfs(grid,xx,yy);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; ++i){
            for (int j = 0; j < grid[0].length; ++j){
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
