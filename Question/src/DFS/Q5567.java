package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5567 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void dfs(int s, int depth){
        if(depth==2) return;

        for(int v : graph[s]){
            visited[v] = true;
            dfs(v, depth+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        visited = new boolean[N+1];

        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        visited[1] = true;
        dfs(1, 0);

        int result = 0;
        for(int i=2; i<=N; i++){
            if(visited[i]) result++;
        }

        System.out.println(result);
    }
}
