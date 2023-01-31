import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public HashMap<Character,char[]> hashMap = new HashMap<>();
    public List<String> res = new LinkedList<>();

    public void init(){
        hashMap.put('2',new char[]{'a','b','c'});
        hashMap.put('3',new char[]{'d','e','f'});
        hashMap.put('4',new char[]{'g','h','i'});
        hashMap.put('5',new char[]{'j','k','l'});
        hashMap.put('6',new char[]{'m','n','o'});
        hashMap.put('7',new char[]{'p','q','r','s'});
        hashMap.put('8',new char[]{'t','u','v'});
        hashMap.put('9',new char[]{'w','x','y','z'});
    }

    public void backtracking(String str,String num){
        if (num.length() == 0){
            res.add(str);
            return;
        }
        char ch = num.charAt(0);
        for (char temp : hashMap.get(ch)){
            backtracking(str + Character.toString(temp),num.substring(1));
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new LinkedList<>();
        init();
        backtracking("",digits);
        return res;
    }

    public static void main(String[] args) {

    }
}
