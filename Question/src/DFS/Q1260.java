package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260 {
    static int[][] graph;
    static int n;
    static boolean[] visited1;
    static boolean[] visited2;
    static StringBuilder sb;

    static void dfs(int v){
        visited1[v] = true;
        sb.append(v).append(" ");
        for(int i=1; i<=n; i++){
            if(!visited1[i] && graph[v][i]==1) dfs(i);
        }
    }

    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        visited2[v] = true;
        q.offer(v);
        sb.append(v).append(" ");

        while(!q.isEmpty()){
            v = q.poll();
            for(int i=1; i<=n; i++){
                if(!visited2[i] && graph[v][i]==1){
                    visited2[i] = true;
                    sb.append(i).append(" ");
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited1 = new boolean[n+1];
        visited2 = new boolean[n+1];

        graph = new int[n+1][n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        
        dfs(r);
        sb.append("\n");
        bfs(r);

        System.out.println(sb);
    }
}
