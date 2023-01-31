

public class Main {

    public static String cut(String str){
        if (str.length() == 0) return str;
        char pre = str.charAt(0);
        for (int i = 1; i < str.length(); ++i){
            char new_char = str.charAt(i);
            if (Math.abs(pre - new_char) == 32){
                return str.substring(0,i-1) + str.substring(i+1);
            }
            pre = new_char;
        }
        return str;
    }

    public static String makeGood(String s) {
        int len = s.length();
        String res = cut(s);
        while (len != res.length()){
            len = res.length();
            res = cut(res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(makeGood(""));
    }
}
