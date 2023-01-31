import java.util.HashMap;

public class Main {

    public static int longestAwesome(String s) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        int pre = 0;
        int ans = 0;
        hashMap.put(0,-1);
        for (int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            pre = pre ^ (1 << (ch-'0'));

            for (int j = 0; j < 10; ++j){
                int next = pre ^ (1 << j);
                if (hashMap.containsKey(next)){
                    ans = Math.max(ans,i - hashMap.get(next));
                }
            }

            if (!hashMap.containsKey(pre)){
                hashMap.put(pre,i);
            }else {
                ans = Math.max(ans,i - hashMap.get(pre));
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestAwesome("00"));
    }
}
