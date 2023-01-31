


public class Main {

    public static int get_Zero(String str){
        int num = 0;
        for (int i = 0;i < str.length(); ++i){
            if (str.charAt(i) == '0') num++;
        }
        return num;
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int [][]dp = new int[m+1][n+1];
        for (int i = m; i >= get_Zero(strs[0]); --i)
            for (int j = n; j >= strs[0].length()-get_Zero(strs[0]); --j)
                dp[i][j] = 1;

        for (int i = 1; i < strs.length; ++i){
            int num_0 = get_Zero(strs[i]);
            int num_1 = strs[i].length()-num_0;
            for (int j = m; j >= 0; --j){
                for (int k = n; k >= 0; --k){
                    int left_0 = j - num_0;
                    int left_1 = k - num_1;
                    dp[j][k] = dp[j][k];
                    if (left_0 >= 0 && left_1 >= 0){
                        dp[j][k] = Math.max(dp[j][k],dp[left_0][left_1]+1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3));
    }
}
