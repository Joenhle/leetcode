import java.util.Arrays;

public class Main {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int num = 0;
        for (int i = 0; i < s.length; ++i) {
            if (s[i] >= g[num])
                num++;
            if (num >= g.length)
                break;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1, 2};
        int[] s = new int[]{1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }


}
