

public class Main {

    public static int numberOfArithmeticSlices(int[] arr) {

        int cnt[][] = new int[arr.length][2];

        if (arr.length < 3) return 0;

        cnt[0][0] = 1;
        cnt[0][1] = 0;
        cnt[1][0] = 2;
        cnt[1][1] = arr[1] - arr[0];

        int dp[] = new int[arr.length];

        if (arr[2]-arr[1] == arr[1]-arr[0]) {
            dp[2] = 1;
            cnt[2][0] = 3;
            cnt[2][1] = arr[2]-arr[1];
        }else {
            cnt[2][0] = 2;
            cnt[2][1] = arr[2]-arr[1];
        }



        for (int i = 3; i < arr.length; ++i){
            int diff = arr[i] - arr[i-1];
            int res = 0;
            if (diff == cnt[i-1][1]){
                cnt[i][0] = cnt[i-1][0]+1;
                cnt[i][1] = cnt[i-1][1];
                if (cnt[i][0] >= 3){
                    res = cnt[i][0] - 2;
                }
            }else {
                cnt[i][0] = 2;
                cnt[i][1] = arr[i] - arr[i-1];
            }
            dp[i] = dp[i-1] + res;
        }
        return dp[arr.length-1];
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4,5,6}));
    }
}
