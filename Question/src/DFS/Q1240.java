package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1240 {
    static class Node{
        int d, w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int result;

    static void dfs(int s, int e, int cnt){
        if(s==e){
            result = cnt;
            return;
        }

        visited[s] = true;

        for(Node n : graph[s]){
            if(!visited[n.d]) dfs(n.d, e, cnt+n.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<Node>();

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            visited = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            result = 0;
            dfs(s, e, 0);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
