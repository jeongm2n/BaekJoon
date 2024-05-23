package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1707 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void dfs(int s){
        visited[s] = true;

        for(int v : graph[s]){
            if(!visited[v]) dfs(v);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int z=0; z<K; z++){
            st = new StringTokenizer(br.readLine());
            
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            visited = new boolean[V+1];

            for(int i=1; i<=V; i++) graph[i] = new ArrayList<Integer>();

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
            }
            int cnt = 0;

            for(int i=1; i<=V; i++){
                if(!visited[i]){
                    dfs(i);
                    cnt++;
                }
            }

            sb.append(cnt>1 ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}
