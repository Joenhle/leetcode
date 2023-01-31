import java.util.ArrayList;
import java.util.List;

public class Main {



    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
    }


    public void getDFS(TreeNode root,List<Integer> arr){

        if (root == null)
            return;

        arr.add(root.val);
        if (root.left == null && root.right != null){
            arr.add(0x11112222);
            getDFS(root.right,arr);
        }else if (root.left != null && root.right == null){
            getDFS(root.left,arr);
            arr.add(0x22221111);
        }else if (root.left == null && root.right == null){
            arr.add(0x11112222);
            arr.add(0x22221111);
        }else {
            getDFS(root.left,arr);
            getDFS(root.right,arr);
        }

    }

    public void getNext(Object[] p, int[] next){
        next[0] = -1;
        int i = 0,j = -1;
        while (i < p.length){
            if(j == -1 || p[i].equals(p[j])){
                ++i;
                ++j;
                next[i]=j;
            }else {
                j = next[j];
            }
        }
    }

    public int KMP(Object[] t, Object[] p,int[] next)
    {
        int i = 0;
        int j = 0;

        while (i < t.length && j < p.length)
        {
            if (j == -1 || t[i].equals(p[j]) )
            {
                i++;
                j++;
            }
            else
                j = next[j];
        }

        if (j == p.length)
            return i - j;
        else
            return -1;
    }


    public boolean isSubtree(TreeNode a, TreeNode b) {

        List<Integer> a_list = new ArrayList<>();
        List<Integer> b_list = new ArrayList<>();



        getDFS(a,a_list);
        getDFS(b,b_list);

        Object[] a_dfs =  a_list.toArray();
        Object[] b_dfs = b_list.toArray();

        int a_next[] = new int[a_dfs.length+1];
        getNext(a_dfs,a_next);

        if (KMP(a_dfs,b_dfs,a_next)!=-1){
        return true;
        }

        return false;
    }


    public void next(char[] a,int[] next){
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < a.length){
            if (j == -1 || a[i] == a[j]){
                i++;
                j++;
                next[i] = j;
            }else {
                j = next[i];
            }
        }
    }

    public int kmp(char[] a,char[] b,int[] next){
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length){
            if (a[i] == b[i]){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if (j == b.length){
            return i-j;
        }
        return -1;
    }

    public static void main(String[] args) {


    }


}
