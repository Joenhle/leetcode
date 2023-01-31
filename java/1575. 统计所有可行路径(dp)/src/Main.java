public class Main {



    public static long mod = (long) (Math.pow(10,9) + 7);

    public static int countRoutes(int[] locations, int start, int finish, int fuel) {
        long [][]dp = new long[locations.length][fuel+1];

        for (int j = 1; j <= fuel; ++j){
            for (int i = 0; i < locations.length; ++i){
                for (int k = 0; k < locations.length; ++k){
                    if (k != i && j >= Math.abs(locations[i] - locations[k])){
                        long temp = (k == finish) ? 1 : 0;
                        dp[i][j] += (dp[k][j - Math.abs(locations[i] - locations[k])] + temp);
                    }
                }
                dp[i][j] = dp[i][j] % mod;
            }
        }

        return (int) (dp[start][fuel] + (start == finish ? 1 : 0) % mod);
    }

    public static void main(String[] args) {
        System.out.println(countRoutes(new int[]{1,2,3},0,2,40));
    }
}
