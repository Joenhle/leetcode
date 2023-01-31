public class Main {

    public static String modifyString(String s) {
        String res = new String();
        int k = 0;
        for (int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if (ch != '?') res += Character.toString(ch);
            else {
                boolean flag = true;
                while (flag){
                    if (i-1 >= 0 && 'a'+(k%26) == res.charAt(i-1)){
                        k++;
                        continue;
                    }
                    if (i+1 < s.length() && 'a'+(k%26) == s.charAt(i+1)){
                        k++;
                        continue;
                    }
                    flag = false;
                }
                res += Character.toString((char) ('a'+(k%26)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(modifyString("b?a"));
    }
}
