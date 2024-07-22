package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q19542 {
    static int N, D, cnt;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    static int dfs(int s){
        visited[s] = true;
        int max = 0;

        for(int v : graph[s]){
            if(!visited[v]){
                max = Math.max(max, dfs(v));
            }
        }

        if(max>=D) cnt++;

        return max+1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(S);

        System.out.println((cnt-1)*2);
    }
}
