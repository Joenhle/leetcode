import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Character> b = new ArrayList<>();
    ArrayList<Integer> arrayList[][] = (ArrayList<Integer>[][]) new ArrayList[1000][1000];

    public ArrayList<Integer> matrix(ArrayList<Integer> a, ArrayList<Integer> b, char ch) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i : a) {
            for (int j : b) {
                if ('+' == ch) {
                    result.add(i + j);
                } else if ('-' == ch) {
                    result.add(i - j);
                } else if ('*' == ch) {
                    result.add(i * j);
                }
            }
        }

        return result;
    }

    public void init(String input) {

        int i = 0;
        while (i < input.length()) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                b.add(ch);
            }
            i = i + 1;
        }
        input = input.replace("+", ",");
        input = input.replace("-", ",");
        input = input.replace("*", ",");
        String temp[] = input.split(",");
        for (String num : temp) {
            a.add(Integer.valueOf(num));
        }
    }

    public ArrayList<Integer> merge(int l, int r) {
        if (arrayList[l][r] != null) {
            return arrayList[l][r];
        }
        ArrayList<Integer> temp = new ArrayList<>();
        if (l == r) {
            int value = a.get(l);
            temp.add(value);

        } else {
            for (int k = l; k < r; ++k) {
                temp.addAll(matrix(merge(l, k), merge(k + 1, r), b.get(k)));
            }
        }
        arrayList[l][r] = temp;
        return arrayList[l][r];
    }

    public List<Integer> diffWaysToCompute(String input) {
        init(input);
        List<Integer> result = merge(0, a.size() - 1);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        List<Integer> result = main.diffWaysToCompute("2*3-4*5");
        for (int i : result) {
            System.out.println(i);
        }
    }
}
