import java.util.HashMap;
import java.util.HashSet;

public class Main {


    public static int numSplits(String s) {
        int len = s.length();
        int order[] = new int[len+1];
        int inorder[] = new int[len+1];
        HashSet<Character> hashSet_order = new HashSet<>();
        HashSet<Character> hashSet_inorder = new HashSet<>();
        for (int i = 0; i < len; ++i){
            char ch = s.charAt(i);
            if (!hashSet_order.contains(ch)){
                hashSet_order.add(ch);
            }
            ch = s.charAt(len-i-1);
            if (!hashSet_inorder.contains(ch)){
                hashSet_inorder.add(ch);
            }
            order[i+1] = hashSet_order.size();
            inorder[i+1] = hashSet_inorder.size();
        }

        int sum = 0;
        for (int i = 1; i <= s.length()-1; ++i){
            if (order[i] == inorder[s.length()-i])
                sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numSplits("a"));
    }
}
