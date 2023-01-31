public class Main {

    public static int minFlips(String target) {

        int cnt = 0;
        for (int i = 0; i < target.length(); ++i){
            char ch = target.charAt(i);
            if (cnt % 2 == 0){
                if (ch == '1')
                    cnt++;
            }else {
                if (ch == '0')
                    cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(minFlips("001011101"));
    }
}
