import java.util.Queue;
import java.util.LinkedList;

import java.util.HashMap;


public class Main {

    public static int shortestPathBinaryMatrix(int[][] grid){
        int step[][] = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid.length; ++j) {
                step[i][j] = 0x3333ffff;
            }
        }
        if (grid[0][0] == 1)
            return -1;
        step[0][0] = 1;

        Queue<HashMap<String, Integer>> queue = new LinkedList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("i", 0);
        hashMap.put("j", 0);
        queue.offer(hashMap);

        while (!queue.isEmpty()) {
            HashMap pos = queue.poll();
            int i = (int)pos.get("i");
            int j = (int)pos.get("j");

            for (int m = -1; m <= 1; ++m) {
                for (int n = -1; n <= 1; ++n) {
                    if (m == 0 && n == 0)
                        continue;
                    int next_i = i + m;
                    int next_j = j + n;
                    if (next_i < 0 || next_i >= grid.length || next_j < 0 || next_j >= grid.length || grid[next_i][next_j] == 1 || step[next_i][next_j]!=0x3333ffff)
                        continue;
                    step[next_i][next_j] = step[i][j] + 1;
                    if (next_i == grid.length-1 && next_j == grid.length-1)
                        return step[grid.length-1][grid.length-1] == 0x3333ffff ? -1 : step[grid.length-1][grid.length-1];
                    HashMap<String,Integer> new_pos = new HashMap<>();
                    new_pos.put("i",next_i);
                    new_pos.put("j",next_j);
                    queue.offer(new_pos);
                }
            }
        }

        return step[grid.length-1][grid.length-1] == 0x3333ffff ? -1 : step[grid.length-1][grid.length-1];
    }

    public static void main(String[] args) throws InterruptedException {
        int grid[][] = {{0,0,1,0,0,0,0},{0,1,0,0,0,0,1},{0,0,1,0,1,0,0},{0,0,0,1,1,1,0},{1,0,0,1,1,0,0},{1,1,1,1,1,0,1},{0,0,1,0,0,0,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
