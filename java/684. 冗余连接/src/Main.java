public class Main {


    public int f[] = null;

    public void init(){
        for (int i = 0; i < f.length; ++i){
            f[i] = i;
        }
    }

    public int find_father(int x){
        if (f[x] != x)
            f[x] = find_father(f[x]);
        return f[x];
    }

    public void union(int x, int y){
        int a = find_father(x);
        int b = find_father(y);
        if (a == b) return;
        f[a] = b;
    }

    public int[] findRedundantConnection(int[][] edges) {
        f = new int[edges.length+1];
        init();
        for (int[] edge : edges){
            if (find_father(edge[0]) == find_father(edge[1]))
                return edge;
            union(edge[0],edge[1]);
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
