package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18126 {
    static class Edge{
        int d, w;
        public Edge(int d, int w){
            this.d = d;
            this.w = w;
        }
    }
    static ArrayList<Edge>[] list;
    static boolean[] visited;
    static long max = -1;

    static void dfs(int s, long d){
        max = Math.max(max, d);
        visited[s] = true;

        for(Edge e : list[s]){
            if(!visited[e.d]){
                dfs(e.d, d+e.w);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) list[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Edge(v, w));
            list[v].add(new Edge(u, w));
        }

        dfs(1, 0);
        System.out.println(max);
    }
}
