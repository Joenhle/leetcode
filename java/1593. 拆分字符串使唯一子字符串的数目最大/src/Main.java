import java.util.HashSet;

public class Main {


    public static HashSet<String> res = new HashSet<>();

    public static HashSet<String> backtracking(HashSet<String> hashSet,String str){
        if (str.length() == 0) return hashSet;
        HashSet<String> ans = new HashSet<>();

        if (hashSet.size() + str.length() < res.size()) return ans;

        for (int i = 0; i < str.length(); ++i){
            if (!hashSet.contains(str.substring(0,i+1))){
                hashSet.add(str.substring(0,i+1));
                if (backtracking(hashSet,str.substring(i+1)).size() > ans.size()){
                    ans = new HashSet<>(backtracking(hashSet,str.substring(i+1)));
                }
                hashSet.remove(str.substring(0,i+1));
            }
        }

        if (ans.size() > res.size()){
            res = ans;
        }

        return ans;
    }

    public static int maxUniqueSplit(String s) {
        backtracking(new HashSet<>(),s);
        return res.size();
    }

    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("cchkababdagpbtlb"));
    }
}
