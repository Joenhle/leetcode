import java.util.ArrayList;


public class Main {

    public static int next[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public static ArrayList<int []> arrayList = new ArrayList<>();

    public static int dfs(int [][]grid, int x , int y,boolean flag[][]){
        arrayList.add(new int[]{x,y});
        flag[x][y] = true;
        int sum = 1;
        for (int i = 0; i < 4; i++){
            int xx = x + next[i][0];
            int yy = y + next[i][1];
            if (xx < 0 || xx >= grid.length || yy < 0 || yy >= grid[0].length) continue;
            if (flag[xx][yy] == false && grid[xx][yy] == 1){
                sum = sum + dfs(grid,xx,yy,flag);
            }
        }
        return sum;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        boolean traveled[][] = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; ++i){
            for (int j = 0; j < grid[0].length; ++j){
                if (grid[i][j] == 0)
                    traveled[i][j] = true;
                else {
                    if (traveled[i][j] == false){
                        int max = dfs(grid,i,j,new boolean[grid.length][grid[0].length]);
                        res = Math.max(res,max);
                        for (int []temp : arrayList){
                            traveled[temp[0]][temp[1]] = true;
                        }
                        arrayList.clear();
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{{0,0,0,0,1,1,1,0},{0,0,0,1,1,0,0,0}}));
    }
}
