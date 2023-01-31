public class Main {

    public static long mod = (long) (Math.pow(10,9)+7);

    public static int maxProductPath(int[][] grid) {
        long [][][]dp = new long[grid.length][grid[0].length][2];

        boolean zero_exist = false;


        long sum = 1;
        for (int i = 0; i < grid.length; ++i){
            int k = sum*grid[i][0] >= 0 ? 0 : 1;
            sum = sum*grid[i][0];
            dp[i][0][k] = sum;
            if (grid[i][0] == 0) zero_exist = true;
        }
        sum = 1;
        for (int j = 0; j < grid[0].length; ++j){
            int k = sum*grid[0][j] >= 0 ? 0 : 1;
            sum = sum*grid[0][j];
            dp[0][j][k] = sum;
            if (grid[0][j] == 0) zero_exist = true;
        }

        for (int i = 1; i < grid.length; ++i){
            for (int j = 1; j < grid[0].length; ++j){
                if (grid[i][j] == 0) zero_exist = true;
                if (grid[i][j] >= 0){
                    dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i][j-1][0])*grid[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][1],dp[i][j-1][1])*grid[i][j];
                }else {
                    dp[i][j][0] = Math.min(dp[i-1][j][1],dp[i][j-1][1])*grid[i][j];
                    dp[i][j][1] = Math.max(dp[i-1][j][0],dp[i][j-1][0])*grid[i][j];
                }
            }
        }
        int res = (int) (dp[grid.length-1][grid[0].length-1][0] % mod);
        if (res > 0){
            return res;
        }else if (res == 0){
            if (zero_exist) {
                return 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(maxProductPath(new int[][]{{1,4,4,0},{-2,0,0,1},{1,-1,1,1}}));
    }
}
