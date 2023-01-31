public class Main {

    public static int swap(int[] arr, int left,int right){
        int cnt = 0;
        for (int i = right; i >= left + 1; --i){
            int temp = arr[i-1];
            arr[i-1] = arr[i];
            arr[i] = temp;
            cnt++;
        }
        return cnt;
    }

    public static int minSwaps(int[][] grid) {

        int arr[] = new int[grid.length];
        int dp[] = new int[grid.length];

        for (int i = 0; i < grid.length; ++i){
            int cnt = 0;
            for (int j = grid[0].length-1; j >= 0; --j){
                if (grid[i][j] == 0) cnt++;
                else break;
            }
            arr[i] = cnt;
        }


        for (int i = 0; i < grid.length; ++i){
            if (arr[i] >= arr.length-i-1){
                dp[i] = i == 0 ? 0 : dp[i-1];
            }else {
                for (int j = i + 1; j < grid.length; ++j){
                    if (arr[j] >= arr.length-i-1){
                        dp[i] =  i == 0 ? swap(arr,i,j) : dp[i-1] + swap(arr,i,j);
                        break;
                    }
                    if (j == grid.length-1) return -1;
                }

            }
        }

        return dp[arr.length-1];
    }

    public static void main(String[] args) {
        System.out.println(minSwaps(new int[][]{{0,1,1,0},{0,1,1,0},{0,1,1,0},{0,1,1,0}}));
    }

}

