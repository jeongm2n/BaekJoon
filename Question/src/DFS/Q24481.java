package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q24481 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] dist;

    static void dfs(int s){
        visited[s] = true;

        for(int v : graph[s]){
            if(!visited[v]){
                dist[v] = dist[s]+1;
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, -1);

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i=1; i<=N; i++) Collections.sort(graph[i]);
        dist[S] = 0;
        dfs(S);

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++){
            sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }   
}
