public class Main {

    public static int maxDepth(String s) {
        if (s.length() == 0) return 0;
        int num = 0;
        int res = 0;
        for (int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if (ch == '('){
                num++;
                res = Math.max(res,num);
            }else if (ch == ')'){
                num--;
            }
            if (num < 0) return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("1"));
    }
}
