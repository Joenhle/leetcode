import java.util.LinkedList;

public class Main {

    public static int getMax(int []prices,int l,int r){
        if (l == r) return 0;
        int min = 0x3333ffff;
        int max = -0x3333ffff;
        int ans = 0;
        for (int i = l; i <= r; ++i){
            if (prices[i] > max){
                max = prices[i];
                ans = Math.max(ans,max-min);
            }
            if(prices[i] < min){
                min = prices[i];
                max = -0x3333ffff;
            }
        }
        return ans;
    }

    public static int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length; ++i){
            int a = getMax(prices,0,i);
            int b = i + 1 == prices.length ? 0 : getMax(prices,i+1,prices.length-1);
            ans = Math.max(ans,a+b);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{}));
    }
}
