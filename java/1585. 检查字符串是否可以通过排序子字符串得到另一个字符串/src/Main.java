import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static Queue<Integer> queue[] = new Queue[10];

    public static boolean isTransformable(String s, String t) {

        if (s.length() != t.length()) return false;

        for (int i = 0; i < 10; ++i){
            queue[i] = new LinkedList<>();
        }

        for (int i = 0; i < s.length(); ++i){
            int num = s.charAt(i)-'0';
            queue[num].add(i);
        }

        for (int i = 0; i < t.length(); ++i){
            int num = t.charAt(i)-'0';
            if (queue[num].size() == 0) return false;
            for (int j = 0; j < num; ++j){
                if (queue[j].size() != 0 && queue[j].peek() < queue[num].peek()){
                    return false;
                }
            }
            queue[num].poll();
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(isTransformable("84532","34852"));
        //System.out.println(isTransformable("34521","23415"));
        System.out.println(isTransformable("1","2"));
    }
}
