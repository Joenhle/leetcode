import java.util.ArrayList;
import java.util.List;

public class Main {



    public static int[] gardenNoAdj(int N, int[][] paths) {
        ArrayList<Integer> []arrayLists = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            arrayLists[i] = new ArrayList<>();
        int res[] = new int[N];
        for (int i = 0; i < paths.length; ++i){
            arrayLists[paths[i][0]-1].add(paths[i][1]-1);
            arrayLists[paths[i][1]-1].add(paths[i][0]-1);
        }
        for (int i = 0; i < N; ++i){
            int temp[] = new int[4];
            for (int next : arrayLists[i]){
                if (res[next] != 0){
                    temp[res[next]-1] = 1;
                }
            }
            for (int j = 0; j < 4; ++j){
                if (temp[j] == 0){
                    res[i] = j+1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(gardenNoAdj(4,new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}}));
    }
}
