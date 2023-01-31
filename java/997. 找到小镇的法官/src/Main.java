public class Main {

    public int findJudge(int N, int[][] trust) {
        int arr[][] = new int[N][2];
        for (int i = 0; i < trust.length; ++i){
            int a = trust[i][0]-1;
            int b = trust[i][1]-1;
            arr[a][0]++;
            arr[b][1]++;
        }
        for (int i = 0; i < N; ++i){
            if (arr[i][0] == 0 && arr[i][1] == N-1)
                return i+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
