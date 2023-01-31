import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static int[] f = null;

    public static int find_father(int i){
        if (f[i] == -1)
            return i;
        return find_father(f[i]);
    }

    public static void merge(int i, int j){
        int a = find_father(i);
        int b = find_father(j);
        if (a != b){
            f[a] = b;
        }
    }

    public static int findCircleNum(int[][] M) {
        f = new int[M.length];
        Arrays.fill(f,-1);
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < M.length; ++i){
            for (int j = 0; j < M[0].length; ++j){
                if (M[i][j] == 1 && i != j){
                    merge(i,j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < M.length; ++i){
            if (f[i] == -1)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
    }
}
