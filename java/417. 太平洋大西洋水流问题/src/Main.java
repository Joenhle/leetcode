import java.util.LinkedList;
import java.util.List;

public class Main {

    public int next[][] = {{1,0},{-1,0},{0,1},{0,-1}};

    void dfs(int [][]matrix, int x, int y,int arr[][]){
        arr[x][y] = 1;
        for (int i = 0; i < 4; ++i){
            int xx = x + next[i][0];
            int yy = y + next[i][1];
            if (xx < 0 || xx >= matrix.length || yy < 0 || yy >= matrix[0].length || arr[xx][yy] == 1) continue;
            if (matrix[xx][yy] > matrix[x][y]){
                dfs(matrix,xx,yy,arr);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0) return new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        int arr1[][] = new int[matrix.length][matrix[0].length];
        int arr2[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i){
            for (int j = 0; j < matrix[0].length; ++j){
                if (i == 0 || j == 0)
                    dfs(matrix,i,j,arr1);
                if (i == matrix.length-1 || j == matrix[0].length-1)
                    dfs(matrix,i,j,arr2);
            }
        }

        for (int i = 0; i < matrix.length; ++i){
            for (int j = 0; j < matrix[0].length; ++j){
                if (arr1[i][j] == 1 && arr2[i][j] == 1){
                    List<Integer> point = new LinkedList<>();
                    point.add(i);
                    point.add(j);
                    res.add(point);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
