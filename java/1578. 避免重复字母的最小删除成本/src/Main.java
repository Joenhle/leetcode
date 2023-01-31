public class Main {

    public static int minCost(String s, int[] cost) {
        if (s.length() <= 1) return 0;
        char pre = s.charAt(0);
        int res = 0,sum = cost[0],max = cost[0];
        for (int i = 1; i < s.length(); ++i){
            if (s.charAt(i) == pre){
                sum += cost[i];
                max = Math.max(max,cost[i]);
            }else {
                res += (sum - max);
                sum = cost[i];
                max = cost[i];
            }
            pre = s.charAt(i);
        }
        res += (sum -max);
        return res;
    }

    public static void main(String[] args){
        System.out.println(minCost("aabaa",new int[]{1,2,3,4,1}));
    }
}
