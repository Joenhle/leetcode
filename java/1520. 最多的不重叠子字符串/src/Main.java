import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static HashMap<String,List<String>> hashMap = new HashMap<>();

    public static List<String> merge(List<String> l1,List<String> l2,String s){
        int a[] = new int[l1.size()];
        int b[] = new int[l2.size()];
        int ch1[] = new int[26];
        int ch2[] = new int[26];
        for (int i = 0; i < l1.size(); ++i){
            String arr = l1.get(i);
            for (int j = 0; j < arr.length(); ++j){
                ch1[arr.charAt(j)-'a']++;
            }
        }
        for (int i = 0; i < l2.size(); ++i){
            String arr = l2.get(i);
            for (int j = 0; j < arr.length(); ++j){
                ch2[arr.charAt(j)-'a']++;
                if (ch1[arr.charAt(j)-'a'] > 0)
                    b[i]++;
            }
        }
        for (int i = 0; i < l1.size(); ++i){
            String arr  = l1.get(i);
            for (int j = 0; j < arr.length(); ++j){
                if (ch2[arr.charAt(j)-'a'] > 0){
                    a[i]++;
                }
            }
        }
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < a.length; ++i){
            if (a[i] == 0 && check(l1.get(i),s)) ans.add(l1.get(i));
        }
        for (int i = 0; i < b.length; ++i){
            if (b[i] == 0 && check(l2.get(i),s)) ans.add(l2.get(i));
        }
        return ans;
    }

    public static boolean check(String son,String s){
        int a[] = new int[26];
        int sum[] = new int[26];
        for (int i = 0; i < son.length(); ++i){
            a[son.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); ++i){
            sum[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; ++i){
            if (a[i] > 0 && a[i] != sum[i])
                return false;
        }
        return true;

    }

    public static int getLength(List<String> l1){
        int sum = 0;
        for (String temp : l1)
            sum += temp.length();
        return sum;
    }

    public static List<String> maxNumOfSubstrings(String s) {
        if (hashMap.containsKey(s)) return hashMap.get(s);
        List<String> max = new LinkedList<String>();
        max.add(s);
        int len = getLength(max);
        for (int i = 0; i <= s.length()-2; ++i){
            List<String> left = maxNumOfSubstrings(s.substring(0,i+1));
            List<String> right = maxNumOfSubstrings(s.substring(i+1,s.length()));
            List<String> ans = merge(left,right,s);

            if (ans.size() > max.size()){
                max = ans;
                len = getLength(max);
            }else if (ans.size() == max.size()){
                if (getLength(ans) < len){
                    max = ans;
                    len = getLength(max);
                }
            }

        }
        hashMap.put(s,max);
        return max;
    }

    public static void main(String[] args) {
        List<String> ans = maxNumOfSubstrings("zyz");
        System.out.println(ans.toString());
    }

}
