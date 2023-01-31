public class Main {


    public static int minInsertions(String s) {

        int left = 0,ans = 0;
        for (int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if (ch == '(') {
                left++;
            }else {
                if (i+1 < s.length() && s.charAt(i+1)==')') i++;
                else ans++;
                if (left > 0) --left;
                else ans++;
            }
        }
        ans += 2*left;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("(()))"));
    }
}
