import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    double [][]result = new double[10000][2];
    public void dfs(TreeNode root,int depth){
        if (root == null)
            return;
        result[depth][1]++;
        result[depth][0]+=root.val;
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }

    public List<Double> averageOfLevels(TreeNode root) {

        if (root==null)
            return new LinkedList<>();
        dfs(root,1);
        List<Double> result_list = new LinkedList<>();
        int i = 1;
        while (true){
            if (result[i][1]==0)
                break;
            result_list.add(new Double(result[i][0]/result[i][1]));
            i++;
        }
        return result_list;
    }

    public static void main(String[] args) {

    }


}
