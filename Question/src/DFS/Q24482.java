package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q24482 {
    static int[] depth;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void dfs(int s){
        visited[s] = true;

        for(int v : graph[s]){
            if(!visited[v]){
                depth[v] = depth[s]+1;
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
        depth = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        Arrays.fill(depth, -1);
        depth[S] = 0;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i=1; i<=N; i++) Collections.sort(graph[i], (o1,o2)->{return o2-o1;});

        dfs(S);

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++) sb.append(depth[i]).append("\n");
        System.out.println(sb);
    }
}
