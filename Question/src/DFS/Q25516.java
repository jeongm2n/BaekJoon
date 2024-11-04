package DFS;

import java.io.*;
import java.util.*;

public class Q25516 {
    static int n, k;
    static ArrayList<Integer>[] edges;
    static int[] tree;

    static int dfs(int node, int cnt) {
        if (cnt == k+1) return 0;
        int sum = tree[node];
        for (int next : edges[node]) {
            sum += dfs(next, cnt+1);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        tree = new int[n];
        edges = new ArrayList[n];

        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[p].add(c);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) tree[i] = st.nextToken().charAt(0)-'0';
        
        System.out.println(dfs(0, 0));
    }   
}
