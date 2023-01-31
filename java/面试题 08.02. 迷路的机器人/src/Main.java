import java.util.LinkedList;
import java.util.List;

public class Main {
    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int w = obstacleGrid.length;
        int l = obstacleGrid[0].length;
        int [][]ways = new int[w][l];
        ways[0][0] = 1;
        for (int i = 0; i < w; ++i){
            for (int j = 0; j < l; ++j){
                if (obstacleGrid[i][j] == 1) {
                    ways[i][j] = 0;
                    continue;
                }else if (i == 0 && j == 0){
                    continue;
                }
                ways[i][j] = (i-1 >= 0 ? ways[i-1][j] : 0) + (j-1 >= 0 ? ways[i][j-1] : 0);
            }
        }
        if (ways[w-1][l-1] == 0) {
            return new LinkedList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        int x = w-1,y = l-1;
        while (ways[x][y] >= 1){
            LinkedList<Integer> loc = new LinkedList<>();
            loc.add(x);
            loc.add(y);
            res.add(0,loc);
            if (x == 0 && y == 0) {
                break;
            }
            else if (x-1 >= 0 && y >= 0 && ways[x-1][y] >= 1){
                x--;
            }else if (x >= 0 && y-1 >= 0 && ways[x][y-1] >= 1){
                y--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(pathWithObstacles(new int[][]{{1}}));
    }

}
