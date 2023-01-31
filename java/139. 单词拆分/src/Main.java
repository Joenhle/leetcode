import java.util.LinkedList;
import java.util.List;

public class Main {

//    public static boolean wordBreak(String s, List<String> wordDict) {
//        int len = s.length();
//        boolean []arr = new boolean[len];
//        arr[0] = wordDict.contains(s.substring(0,1));
//        for (int i = 1; i < len; ++i){
//            for (int j = 0; j < len; ++j){
//                if (j == 0){
//                    arr[i] = wordDict.contains(s.substring(0,i+1));
//                }else {
//                    arr[i] =  arr[i] || (arr[j-1] && wordDict.contains(s.substring(j,i+1)));
//                }
//
//            }
//        }
//        return arr[len-1];
//    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean []arr = new boolean[len+1];
        arr[0] = true;
        for (int i = 1; i <= len; ++i){
            for (String word : wordDict){
                int word_len = word.length();
                if (i-word_len>=0 && s.substring(i-word_len,i).equals(word)){
                    arr[i] |= arr[i-word_len];
                }
            }
        }
        return arr[len];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("catsandog",new LinkedList<String>(){{add("catsandog");add("cats");add("dog");add("sand");add("and");add("cat");}}));
    }
}
