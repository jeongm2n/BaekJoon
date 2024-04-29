package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11725 {
    static ArrayList<Integer>[] tree;
    static int[] parents;
    static boolean[] visited;

    public static void dfs(int start){
        visited[start] = true;

        for(int i : tree[start]){
            if(!visited[i]){
                parents[i] = start;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        tree = new ArrayList[n+1];
        parents = new int[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++){
            tree[i] = new ArrayList<Integer>();
        }

        StringTokenizer st;
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            tree[parent].add(child);
            tree[child].add(parent);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();

        for(int i=2; i<=n; i++) sb.append(parents[i]).append("\n");
        System.out.println(sb);
    }
}
