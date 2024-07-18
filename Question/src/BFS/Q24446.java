package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q24446 {
    static class Node{
        int u, d;
        public Node(int u, int d){
            this.u = u;
            this.d = d;
        }
    }
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] depth;

    static void bfs(int s){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(s, 0));
        visited[s] = true;
        depth[s] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int v : graph[cur.u]){
                if(!visited[v]){
                    q.offer(new Node(v, cur.d+1));
                    depth[v] = cur.d+1;
                    visited[v] = true; 
                }
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
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        visited = new boolean[N+1];
        depth = new int[N+1];
        Arrays.fill(depth, -1);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        bfs(S);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) sb.append(depth[i]).append("\n");
        System.out.println(sb);
    }
}
